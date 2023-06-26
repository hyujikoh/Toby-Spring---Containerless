package com.inflearn.toby.helloproject.restapi;

public class SimpleHelloService implements HelloService {
    @Override
    public String sayHello(String name){

        return "hello" + name;
    }

}
