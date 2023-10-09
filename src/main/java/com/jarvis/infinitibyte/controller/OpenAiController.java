package com.jarvis.infinitibyte.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jarvis.infinitibyte.manager.ChatManager;
import com.jarvis.infinitibyte.request.ChatRequest;
import com.jarvis.infinitibyte.response.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OpenAiController {

    @Autowired
    private ChatManager chatManager;

    @PostMapping(value="/chat")
    @ResponseBody
    public ChatResponse chat(@RequestBody ChatRequest chatRequest) throws JsonProcessingException {

        return chatManager.chat(chatRequest);
    }
}
