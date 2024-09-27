package com.example.client.controller;

import com.example.client.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "\\message")
@RequiredArgsConstructor
public class MessageController {
    final private MessageService messageService;

    @GetMapping
    ResponseEntity<String> getMessage(){
        return messageService.getMessage();
    };
}
