package com.example.feign.api;

import com.example.service.api.HelloService;
import com.example.service.api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConsumerController {

    @Autowired
    private RefactorHelloService refactorHelloService;

    @GetMapping(value = "/hello4")
    public String hello(@RequestParam("name") String name) {
        return refactorHelloService.hello(name);
    }

    @GetMapping(value = "/hello5")
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return refactorHelloService.hello(name, age);
    }

    @GetMapping("/hello6")
    public String hello(@RequestBody User user) {
        return refactorHelloService.hello(user);
    }
}
