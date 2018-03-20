package com.example.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ClientApplication {

    @Value("${content}")
    String content;

    @RequestMapping("/home")
    public String home() {
        return "content:" + content;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
}
