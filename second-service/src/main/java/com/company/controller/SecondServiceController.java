package com.company.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondServiceController {

    @GetMapping("/hello")
    public String helloPage() {
        return "[Second Service] - " + "hello";
    }

    @PostMapping("/hello")
    public String valuePage(@RequestBody String message) {
        return "[Second Service] - " + message;
    }
}
