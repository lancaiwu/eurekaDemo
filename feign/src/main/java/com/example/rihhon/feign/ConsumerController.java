package com.example.rihhon.feign;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private ComputeClient computeClient;

    @GetMapping(value = "/hello")
    public String hello() {
        return computeClient.hello();
    }
}
