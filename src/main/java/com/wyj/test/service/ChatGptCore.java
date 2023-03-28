package com.wyj.test.service;

import com.plexpt.chatgpt.ChatGPT;
import com.plexpt.chatgpt.ChatGPTStream;
import com.plexpt.chatgpt.entity.billing.CreditGrantsResponse;
import com.plexpt.chatgpt.entity.chat.ChatCompletion;
import com.plexpt.chatgpt.entity.chat.Message;
import com.plexpt.chatgpt.util.Proxys;
import com.wyj.test.utils.JsonUtils;
import okhttp3.sse.EventSourceListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.Proxy;
import java.util.List;

@Service
public class ChatGptCore {

    @Value("${chatgpt.apikey}")
    private String chatGptApiKey;

    public String chat(List<Message> prompts, EventSourceListener listener, String trace) {
//        Proxy proxy = Proxys.http("127.0.0.1", 7890);

        ChatGPTStream chatGPTStream = ChatGPTStream.builder()
                .timeout(600)
                .apiKey(chatGptApiKey)
//                .proxy(proxy)
                .apiHost("https://api.openai.com/")
                .build()
                .init();

        System.out.println(trace + ":debug,prompt=" + JsonUtils.toJson(prompts));
        ChatCompletion chatCompletion = ChatCompletion.builder()
                .messages(prompts)
                .build();
        chatGPTStream.streamChatCompletion(chatCompletion, listener);
        return null;
    }
}
