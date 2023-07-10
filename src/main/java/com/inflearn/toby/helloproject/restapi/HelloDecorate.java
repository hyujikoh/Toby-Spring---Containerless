package com.inflearn.toby.helloproject.restapi;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary// 동일한 조건의 빈이 있을때 우선순위를 지정해서 사용한다는 어노테이션
public class HelloDecorate implements HelloService{
    private final HelloService helloService;

    public HelloDecorate(HelloService helloService) {
        this.helloService = helloService;
    }


    @Override
    public String sayHello(String name) {
        return "*"+ helloService.sayHello(name) + "*";
    }

    @Override
    public int countOf(String count) {
        return helloService.countOf(count);
    }
}
