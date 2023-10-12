package com.jarvis.infinitibyte.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_at")
    private String expiresAt;

    public TokenResponse() {
    }

    public TokenResponse(String accessToken, String expiresAt) {
        this.accessToken = accessToken;
        this.expiresAt = expiresAt;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }
}
