package com.company.controller;

import com.company.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/hello")
    public String helloPage() {
        return "hello";
    }

    @PostMapping("/hello")
    public String valuePage(@RequestBody String message) {
        return message;
    }

    @GetMapping("/test")
    public String testPage() {
        return messageService.getMessage();
    }
}
