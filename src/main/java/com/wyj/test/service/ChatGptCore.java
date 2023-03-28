package com.wyj.test.service;

import com.plexpt.chatgpt.ChatGPT;
import com.plexpt.chatgpt.ChatGPTStream;
import com.plexpt.chatgpt.entity.billing.CreditGrantsResponse;
import com.plexpt.chatgpt.entity.chat.ChatCompletion;
import com.plexpt.chatgpt.entity.chat.Message;
import com.plexpt.chatgpt.listener.ConsoleStreamListener;
import com.plexpt.chatgpt.listener.SseStreamListener;
import com.plexpt.chatgpt.util.Proxys;
import okhttp3.sse.EventSourceListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.net.Proxy;
import java.util.Arrays;

@Service
public class ChatGptCore {


    public void init() {
        Proxy proxy = Proxys.http("127.0.0.1", 7890);

        ChatGPT chatGPT = ChatGPT.builder()
                .apiKey("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")
                .timeout(900)
                .proxy(proxy)
                .apiHost("https://api.openai.com/") //代理地址
                .build()
                .init();

        CreditGrantsResponse response = chatGPT.creditGrants();
        System.out.println("余额：{}" + response.getTotalAvailable());
    }

    //max_tokens: 1000,
    //model: 'gpt-3.5-turbo',
    //temperature: 0.8,
    //top_p: 1,
    //presence_penalty: 1,

    //{ role: 'user', content: '我上上上句说了什么', name: undefined },

    //parent_id: "chatcmpl-6yrZmkseGo0HPdeFjHVPbCrOkoIpk"


    @Value("${chatgpt.apikey}")
    private String chatGptApiKey;
    public String chat(String prompt, EventSourceListener listener) {
        Proxy proxy = Proxys.http("127.0.0.1", 7890);

        ChatGPTStream chatGPTStream = ChatGPTStream.builder()
                .timeout(600)
                .apiKey(chatGptApiKey)
                .proxy(proxy)
                .apiHost("https://api.openai.com/")
                .build()
                .init();

        Message message = Message.of(prompt);
        ChatCompletion chatCompletion = ChatCompletion.builder()
                .messages(Arrays.asList(message))
                .build();
        chatGPTStream.streamChatCompletion(chatCompletion, listener);
        return null;
    }
}