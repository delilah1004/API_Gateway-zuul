package com.company.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MessageService {

    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:9000/api").build();

    @HystrixCommand(fallbackMethod = "getMessageFallBack")
    public String getMessage() {
        return webClient.get()
                .uri("/test")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
    private String getMessageFallBack() {
        return "fallback message";
    }

}
