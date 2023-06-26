package com.inflearn.toby.helloproject.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RequestMapping("/hello")
public class HelloController {
    // final 을 사용할때 초기화를 해야한다.
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }


    @GetMapping
    @ResponseBody
    public String hello(String name){
        // 객체에 대해 notnull 로 처리
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
