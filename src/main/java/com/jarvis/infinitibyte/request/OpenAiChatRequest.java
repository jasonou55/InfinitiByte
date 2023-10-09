package com.jarvis.infinitibyte.request;

import java.util.List;

public class OpenAiChatRequest {
    private String model;
    private List<OpenAiMessage> messages;

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<OpenAiMessage> getMessages() {
        return this.messages;
    }

    public void setMessages(List<OpenAiMessage> messages) {
        this.messages = messages;
    }
}
