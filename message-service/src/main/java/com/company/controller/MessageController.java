package com.company.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MessageController {

    @GetMapping("/hello")
    public String helloPage() {
        return "hello";
    }

    @PostMapping("/hello")
    public String valuePage(@RequestBody String message) {
        return message;
    }

    @GetMapping("/test")
    @HystrixCommand(fallbackMethod = "getMessageFallBack")
    public String testPage(@RequestParam Map<String, String> param) {

        String message = param.get("message");

        if(message.equalsIgnoreCase("error"))
            throw new RuntimeException();

        return message;
    }

    @PostMapping("/test")
    @HystrixCommand(fallbackMethod = "postMessageFallBack")
    public String hystrixPage(@RequestBody String message) {

        if(message.equalsIgnoreCase("error"))
            throw new RuntimeException();

        return message;
    }

    public String getMessageFallBack(@RequestParam Map<String, String> param) {
        System.out.println("Inside Fallback");

        String message = param.get("message");

        return "fallback message : " + message;
    }

    public String postMessageFallBack(@RequestBody String message) {
        System.out.println("Inside Fallback");

        return "fallback message : " + message;
    }
}
