package com.jarvis.infinitibyte.request;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class OpenAiMessage {

    @Valid
    @NotBlank
    private String role;

    @Valid
    @NotBlank
    private String content;

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
