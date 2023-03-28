package com.wyj.test.web.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChatRequest implements Serializable {
    private String prompt;
    private ChatRequestOption options;
    private String systemMessage;

    @Data
    public static class ChatRequestOption implements Serializable {
        private String parentMessageId;
    }

    public String getParentMessageId() {
        if (options == null) {
            return null;
        }
        return options.getParentMessageId();
    }
}