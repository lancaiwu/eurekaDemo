package com.example.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class SleuthApplication {
    // https://blog.csdn.net/forezp/article/details/76795269
    public static void main(String[] args) {
        SpringApplication.run(SleuthApplication.class, args);
    }
}
