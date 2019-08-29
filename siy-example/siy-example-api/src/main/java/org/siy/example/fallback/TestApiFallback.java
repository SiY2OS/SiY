package org.siy.example.fallback;

import org.springframework.stereotype.Component;
import org.siy.example.api.TestApi;
@Component
public class TestApiFallback implements TestApi {
    @Override
    public String sayHello(String name) {
        return "service is invalid!";
    }
}
