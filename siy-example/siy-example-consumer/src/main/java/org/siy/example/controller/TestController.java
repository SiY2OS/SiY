package org.siy.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.siy.example.amqp.Sender;
import org.siy.example.api.Test2Api;
import org.siy.example.api.TestApi;

/**
 * @author Ryan
 */
@RestController
@RefreshScope
public class TestController {

    @Autowired
    private TestApi testApi;

    @Autowired
    private Test2Api test2Api;

    @Value("${from}")
    private String from;

    @Autowired
    private Sender sender;

    @GetMapping("/hello2/{name}")
    public String sayHello2(@PathVariable String name) {
        return test2Api.sayHello(name);
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return testApi.sayHello(name);
    }

    @GetMapping("/from")
    public String from() {
        return this.from;
    }

    @GetMapping("/mq/hello")
    public String sendMessage() {
        sender.send();
        return "success";
    }

}
