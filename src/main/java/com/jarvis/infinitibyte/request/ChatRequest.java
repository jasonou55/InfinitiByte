package com.jarvis.infinitibyte.request;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class ChatRequest {

    @Valid
    @NotBlank
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
