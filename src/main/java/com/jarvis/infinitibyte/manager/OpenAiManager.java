package com.jarvis.infinitibyte.manager;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jarvis.infinitibyte.response.OpenAiChatResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jarvis.infinitibyte.request.OpenAiChatRequest;
import com.jarvis.infinitibyte.request.OpenAiMessage;

@Service
public class OpenAiManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenAiManager.class);
    private static final String OPEN_AI_HOST = "https://api.openai.com/v1/chat/completions";
    private final RestTemplate restTemplate = new RestTemplate();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${openai.key}")
    private String token;

    public OpenAiChatResponse chat(String content) throws JsonProcessingException {
        LOGGER.info("Send content to openAi ----->>>>>>");
        OpenAiMessage openAiMessage = new OpenAiMessage();
        openAiMessage.setRole("user");
        openAiMessage.setContent(content);
        List<OpenAiMessage> messages = new ArrayList<>();
        messages.add(openAiMessage);

        OpenAiChatRequest openAiChatRequest = new OpenAiChatRequest();
        openAiChatRequest.setMessages(messages);
        openAiChatRequest.setModel("gpt-3.5-turbo");

        ResponseEntity<OpenAiChatResponse> openAiChatResponseEntity = restTemplate.exchange(OPEN_AI_HOST, HttpMethod.POST, generateHeaders(openAiChatRequest), OpenAiChatResponse.class);
        LOGGER.info("Get response: " + openAiChatResponseEntity.getStatusCode());
        return openAiChatResponseEntity.getBody();
    }

    private HttpEntity<String> generateHeaders(final OpenAiChatRequest openAiChatRequest) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer " + token);

        return new HttpEntity<>(objectMapper.writeValueAsString(openAiChatRequest), headers);
    }
}