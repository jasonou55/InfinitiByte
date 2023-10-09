package com.jarvis.infinitibyte.response;

import com.jarvis.infinitibyte.request.OpenAiMessage;

public class Choice {
    private long index;
    private OpenAiMessage message;
    private String finish_reason;

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public OpenAiMessage getMessage() {
        return message;
    }

    public void setMessage(OpenAiMessage message) {
        this.message = message;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }
}
