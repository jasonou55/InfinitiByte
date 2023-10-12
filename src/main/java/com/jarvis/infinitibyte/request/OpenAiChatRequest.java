package com.jarvis.infinitibyte.request;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class OpenAiChatRequest {

    @Valid
    @NotBlank
    private String model;

    @Valid
    @NotEmpty
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
