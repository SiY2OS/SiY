package org.siy.example.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.siy.example.fallback.TestApiFallback;

@FeignClient(value = "siy-example-provider", fallback = TestApiFallback.class)
public interface TestApi {

    @GetMapping("/hello/{name}")
    String sayHello(@PathVariable String name);

}
