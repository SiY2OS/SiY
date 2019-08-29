package org.siy.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.siy.example.api.TestApi;
import org.siy.example.service.TestService;

@RestController
public class TestApiImpl implements TestApi {

    @Autowired
    TestService testService;

    @Override
    public String sayHello(String name) {
        return testService.sayHello(name);
    }
}
