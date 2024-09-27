package com.example.client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    public static final String URL = "http://localhost:8080/message/";
    private final RestTemplate restTemplate;
    @Value("${token}")
    String token;

    @Override
    public ResponseEntity<String> getMessage() {

        // Instantiate HttpHeaders to add custom properties.
        HttpHeaders httpHeaders = new HttpHeaders();

        // set the Accept-header as APPLICATION_JSON to get the
        // content in JSON format
        httpHeaders.setAccept(Collections.singletonList(
                MediaType.APPLICATION_JSON));
        httpHeaders.setBearerAuth(token);

        // building a HttpEntity using HttpHeaders to
        // customize the request
        HttpEntity<String> entity
                = new HttpEntity<>(httpHeaders);

        return restTemplate.exchange(URL,
                HttpMethod.GET, entity,
                String.class);

    }
}
