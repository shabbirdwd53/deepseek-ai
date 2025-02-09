package com.dailycodebuffer.deekseek_ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeepSeekController {

    private final ChatClient chatClient;

    public DeepSeekController(@Qualifier("openAiChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/deepseek/{m}")
    public String chat(@PathVariable String m) {
        return chatClient
                .prompt()
                .user(m)
                .call()
                .content();
    }
}
