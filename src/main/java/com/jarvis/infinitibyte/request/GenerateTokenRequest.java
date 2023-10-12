package com.jarvis.infinitibyte.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class GenerateTokenRequest {

    @Valid
    @NotBlank
    @JsonProperty("identityId")
    private String identityId;

    @Valid
    @NotEmpty
    @JsonProperty("isLongTerm")
    private boolean isLongTerm;

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public boolean isLongTerm() {
        return isLongTerm;
    }

    public void setLongTerm(boolean longTerm) {
        isLongTerm = longTerm;
    }
}
