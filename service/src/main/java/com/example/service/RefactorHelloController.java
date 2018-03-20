package com.example.service;

import com.example.service.api.HelloService;
import com.example.service.api.User;
import org.springframework.web.bind.annotation.RestController;

/**
 * 引用 serviceApi 里面的接口，进行实现
 */
@RestController
public class RefactorHelloController implements HelloService {

    @Override
    public String hello(String name) {
        return "Hello " + name;
    }

    @Override
    public User hello(String name, Integer age) {
        return new User(name, age);
    }

    @Override
    public String hello(User user) {
        return "Hello " + user.getName() + " , " + user.getAge();
    }
}
