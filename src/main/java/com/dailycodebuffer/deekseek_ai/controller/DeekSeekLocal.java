package com.dailycodebuffer.deekseek_ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeekSeekLocal {

    private final ChatClient chatClient;

    public DeekSeekLocal(@Qualifier("ollamaChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/deepseeklocal/{m}")
    public String chat(@PathVariable String m) {
        return chatClient
                .prompt()
                .user(m)
                .call()
                .content();
    }
}
