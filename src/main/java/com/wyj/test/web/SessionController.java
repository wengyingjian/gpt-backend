package com.wyj.test.web;

import com.alibaba.fastjson2.util.DateUtils;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.plexpt.chatgpt.ChatGPTStream;
import com.plexpt.chatgpt.entity.chat.Message;
import com.plexpt.chatgpt.listener.AbstractStreamListener;
import com.plexpt.chatgpt.listener.SseStreamListener;
import com.plexpt.chatgpt.util.Proxys;
import com.wyj.test.service.ChatGptCore;
import com.wyj.test.web.response.ChatCompletion;
import com.wyj.test.web.response.Response;
import com.wyj.test.utils.JsonUtils;
import com.wyj.test.web.request.ChatRequest;
import okhttp3.sse.EventSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;

@RestController
public class SessionController {

    private Map<String, Integer> ipHost = new ConcurrentSkipListMap<>();

    private Cache<String, List<Message>> cache = Caffeine.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .expireAfterAccess(10, TimeUnit.MINUTES)
            .maximumSize(10000)
//            .maximumWeight()
            .build();

    public SessionController() throws UnsupportedEncodingException {
    }

    @PostMapping("/api/session")
    public Response session() {
        Response.Data data = new Response.Data();
        data.setAuthenticated(false);
        data.setModelType("ChatGPTAPI");

        Response response = new Response();
        response.setStatus("Success");
        response.setData(data);
        return response;
    }

    @Autowired
    private ChatGptCore chatGptCore;

    private static String DEFAULT_PROMPT = "You are ChatGPT, a large language model trained by OpenAI. " +
            "Answer as concisely as possible." +
            "Knowledge cutoff: 2021-09-01" +
            "Current date: " + new SimpleDateFormat("yyyy-MM-dd").format(new Date());

    private String getIP(HttpServletRequest request) {
        String userIPAddress = request.getHeader("x-forwarded-for");
        if (userIPAddress == null || userIPAddress.isEmpty()) {
            userIPAddress = request.getRemoteAddr();
        }
        return userIPAddress;
    }

    @PostMapping("/api/chat-process")
    public void process(@RequestBody ChatRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws IOException, InterruptedException {
        servletResponse.setContentType("application/octet-stream");
        servletResponse.setCharacterEncoding("UTF-8");
        String ip = getIP(servletRequest);
        String userAgent = servletRequest.getHeader("user-agent");
        print("call-ip:" + ip + " in, userAgent:" + userAgent);
        print("content-ip:" + ip + " request, prompt:" + request.getPrompt());
        ipHost.putIfAbsent(ip, 0);
        ipHost.put(ip, ipHost.get(ip) + 1);

        PrintWriter printWriter = servletResponse.getWriter();

        String id = UUID.randomUUID().toString();
        String parentMessageId = request.getParentMessageId();
        final StringBuilder respMessage = new StringBuilder();

        List<Message> prompts;
        Message systemPrompt = Message.ofSystem(DEFAULT_PROMPT);
        Message messagePrompt = Message.of(request.getPrompt());
        List<Message> history = request.getParentMessageId() == null ? null : cache.getIfPresent(request.getParentMessageId());
        //第一次访问，使用系统PROMPT
        if (CollectionUtils.isEmpty(history)) {
            prompts = Arrays.asList(systemPrompt, messagePrompt);
        } else {
            //后续访问，获取对话历史
            prompts = new ArrayList<>(history);
            prompts.add(messagePrompt);
        }

        final boolean[] flag = {false};
        chatGptCore.chat(prompts, new AbstractStreamListener() {
            @Override
            public void onOpen(EventSource eventSource, okhttp3.Response response) {
                super.onOpen(eventSource, response);
            }

            @Override
            public void onMsg(String s) {
                respMessage.append(s);
                ChatCompletion completion = ChatCompletion.of(id, parentMessageId, s, respMessage.toString(), false);
                printWriter.println(JsonUtils.toJson(completion));
                printWriter.flush();
            }

            @Override
            public void onError(Throwable throwable, String s) {
                throwable.printStackTrace();
            }

            @Override
            public void onClosed(EventSource eventSource) {
                print("content-ip:" + ip + " resp, content:" + respMessage.toString());

                super.onClosed(eventSource);
                ChatCompletion completion = ChatCompletion.of(id, parentMessageId, null, respMessage.toString(), true);
                printWriter.println(JsonUtils.toJson(completion));
                printWriter.flush();
                printWriter.close();

                flag[0] = true;
            }
        }, ip);
        while (!flag[0]) {
            Thread.sleep(100);
        }

        if (request.getParentMessageId() != null) {
            cache.invalidate(request.getParentMessageId());
        }
        List<Message> newHistory = new ArrayList<>(prompts);
        newHistory.add(Message.builder().role("assistant").content(respMessage.toString()).build());
        if (newHistory.size() > 20) {
            newHistory = newHistory.subList(newHistory.size() - 20, newHistory.size());
        }
        cache.put(id, newHistory);
    }

    static PrintWriter out;

    static {
        try {
            out = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void print(String str) {
        out.println(str);
    }

    @Scheduled(cron = "0 0/30 * * * ?")
//    @Scheduled(cron = "1 * * * * *")
    public void printUserAccess() {
        print("printUserAccess:" + ipHost);
    }


}
