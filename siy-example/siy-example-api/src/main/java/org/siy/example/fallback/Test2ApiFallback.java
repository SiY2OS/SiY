package org.siy.example.fallback;

import org.springframework.stereotype.Component;
import org.siy.example.api.Test2Api;

@Component
public class Test2ApiFallback implements Test2Api {
    @Override
    public String sayHello(String name) {
        return "service2 is invalid!";
    }
}
