package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FirstServiceController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String MESSAGE_SERVICE_NAME = "message-service";

    @GetMapping("/hello")
    public String helloPage() {
        ResponseEntity<String> addMessage;
        String apiPath = "/hello";

        addMessage = restTemplate.getForEntity("http://" + MESSAGE_SERVICE_NAME + apiPath, String.class);

        return "[First Service] - " + "hello" + " ---- Added Message : " + addMessage.getBody();
    }

    @PostMapping("/hello")
    public String valuePage(@RequestBody String message) {
        return "[First Service] - " + message;
    }
}
