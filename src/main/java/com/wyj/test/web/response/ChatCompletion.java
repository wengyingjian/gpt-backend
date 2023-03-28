package com.wyj.test.web.response;

import com.wyj.test.utils.JsonUtils;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Data
@Builder
public class ChatCompletion implements Serializable {
    //assistant/system/
    private String role = "assistant";
    private String id;
    private String parentMessageId;
    //累加的
    private String text;
    //本次的
    private String delta;
    private Detail detail;

    @Data
    @Builder
    public static class Detail implements Serializable {
        //同id
        private String id;
        private String object = "chat.completion.chunk";
        //
        private long created;
        //gpt-3.5-turbo-0301
        private String model;
        private List<Choice> choices;

    }

    @Data
    @Builder
    public static class Choice implements Serializable {
        private Delta delta;
        private int index;
        //null/stop
        private String finish_reason;
    }

    @Data
    @Builder
    public static class Delta implements Serializable {
        private String content;

        public String getContent() {
            return content;
        }
    }

    public static ChatCompletion mock(String message) {
        String json = "{\"role\":\"assistant\",\"id\":\"chatcmpl-6ygj8wDefI9f8P7B2okBjwEi76A5q\",\"parentMessageId\":\"f76be2bf-7792-4442-8682-f1b25d0c9fed\",\"text\":\"" + message + "\",\"delta\":\"不\",\"detail\":{\"id\":\"chatcmpl-6ygj8wDefI9f8P7B2okBjwEi76A5q\",\"object\":\"chat.completion.chunk\",\"created\":1679921942,\"model\":\"gpt-3.5-turbo-0301\",\"choices\":[{\"delta\":{\"content\":\"不\"},\"index\":0,\"finish_reason\":null}]}}\n";
        return JsonUtils.fromJson(json, ChatCompletion.class);
    }


    public static ChatCompletion of(String id, String parentMessageId, String deltaMessage, String message, boolean finish) {
        Delta delta = Delta.builder()
                .content(finish ? null : deltaMessage)
                .build();
        Choice choice = Choice.builder()
                .delta(delta)
                .index(0)
                .finish_reason(finish ? "stop" : null)
                .build();
        Detail detail = Detail.builder()
                .id(id)
                .object("chat.completion.chunk")
                .model("gpt-3.5-turbo-0301")
                .created(System.currentTimeMillis())
                .choices(Collections.singletonList(choice))
                .build();
        return ChatCompletion.builder()
                .role("assistant")
                .id(id)
                .parentMessageId(parentMessageId)
                .text(message)
                .delta(finish ? null : deltaMessage)
                .detail(detail)
                .build();
    }
}