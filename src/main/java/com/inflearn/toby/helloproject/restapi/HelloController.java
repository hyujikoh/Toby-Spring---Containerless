package com.inflearn.toby.helloproject.restapi;

import com.inflearn.toby.helloproject.annotation.MyComponent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloController{
    // final 을 사용할때 초기화를 해야한다.
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }


    @GetMapping("/hello")
    public String hello(String name){
        if(name == null || name.trim().length()==0) throw new IllegalArgumentException();

        // 객체에 대해 notnull 로 처리
        return helloService.sayHello(Objects.requireNonNull(name));
    }

    @GetMapping("/count")
    public String helloCount(String name){
        return name + ": "+ helloService.countOf(name);
    }

}
