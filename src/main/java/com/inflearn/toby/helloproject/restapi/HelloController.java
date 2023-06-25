package com.inflearn.toby.helloproject.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String main(String name){
        return "hello world" + name;
    }
}
