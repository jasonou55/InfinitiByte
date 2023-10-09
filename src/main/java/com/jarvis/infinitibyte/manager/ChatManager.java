package com.jarvis.infinitibyte.manager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jarvis.infinitibyte.request.ChatRequest;
import com.jarvis.infinitibyte.response.ChatResponse;
import com.jarvis.infinitibyte.response.Choice;
import com.jarvis.infinitibyte.response.OpenAiChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ChatManager {

    @Autowired
    private OpenAiManager openAiManager;

    public ChatResponse chat(final ChatRequest chatRequest) throws JsonProcessingException {
        if (chatRequest != null && StringUtils.hasLength(chatRequest.getContent())) {
            OpenAiChatResponse openAiChatResponse = openAiManager.chat(chatRequest.getContent());
            List<Choice> choices = openAiChatResponse.getChoices();
            return new ChatResponse(choices.get(0).getMessage().getContent());
        }
        return new ChatResponse("Sorry, I don't understand what you are talking about.");
    }
}
