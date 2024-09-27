package com.example.client.service;

import org.springframework.http.ResponseEntity;

public interface MessageService {
    ResponseEntity<String> getMessage();
}
