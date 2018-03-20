package com.example.eureka.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "hello")
    public String hello() {
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        logger.info("/add, host:" + serviceInstance.getHost() + ", service_id:" + serviceInstance.getServiceId());
        return "hello";
    }
}
