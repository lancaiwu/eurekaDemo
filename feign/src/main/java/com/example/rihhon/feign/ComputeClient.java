package com.example.rihhon.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka.client")
public interface ComputeClient {

    @GetMapping(value = "hello")
    String hello();
}
