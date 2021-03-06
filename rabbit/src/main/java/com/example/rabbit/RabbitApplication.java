package com.example.rabbit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
@RefreshScope
public class RabbitApplication {
    @Value("${content}")
    String content;

    @RequestMapping("/home")
    public String home() {
        return "content:" + content;
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitApplication.class, args);
    }
}
