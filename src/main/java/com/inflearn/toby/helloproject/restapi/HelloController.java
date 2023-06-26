package com.inflearn.toby.helloproject.restapi;

import java.util.Objects;

public class HelloController {

    public String hello(String name){
        SimpleHelloService simpleHelloService = new SimpleHelloService();

        // 객체에 대해 notnull 로 처리
        return simpleHelloService.sayHello(Objects.requireNonNull(name));
    }
}
