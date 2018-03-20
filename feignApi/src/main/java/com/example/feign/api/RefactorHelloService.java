package com.example.feign.api;

import com.example.service.api.HelloService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("eureka.client.service.api")
public interface RefactorHelloService extends HelloService {
}
