package com.wyj.test.web;

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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Proxy;
import java.util.Arrays;
import java.util.UUID;

@RestController
public class SessionController {

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

    @PostMapping("/api/chat-process")
    public void process(@RequestBody ChatRequest request, HttpServletResponse response) throws IOException, InterruptedException {
        System.out.println("11");

        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();


        String id = UUID.randomUUID().toString();
        String parentMessageId = request.getParentMessageId();
        String deltaMessage = "";
        final StringBuilder message = new StringBuilder();
        ChatCompletion completion = ChatCompletion.of(id, parentMessageId, deltaMessage, message.toString(), false);
        printWriter.println(JsonUtils.toJson(completion));
        printWriter.flush();


        final boolean[] flag = {false};
        chatGptCore.chat(request.getPrompt(), new AbstractStreamListener() {
            @Override
            public void onOpen(EventSource eventSource, okhttp3.Response response) {
                super.onOpen(eventSource, response);
                System.out.println("open");
            }

            @Override
            public void onMsg(String s) {
                System.out.print(s);

                message.append(s);
                ChatCompletion completion = ChatCompletion.of(id, parentMessageId, s, message.toString(), false);
                printWriter.println(JsonUtils.toJson(completion));
                printWriter.flush();
            }

            @Override
            public void onError(Throwable throwable, String s) {
                throwable.printStackTrace();
            }

            @Override
            public void onClosed(EventSource eventSource) {
                System.out.println();

                super.onClosed(eventSource);
                ChatCompletion completion = ChatCompletion.of(id, parentMessageId, null, message.toString(), true);
                printWriter.println(JsonUtils.toJson(completion));
                printWriter.flush();
                printWriter.close();
                flag[0] = true;
            }
        });
        while (!flag[0]) {
            Thread.sleep(500);
        }
//

//        printWriter.close();
    }

}
