package com.inflearn.toby.helloproject;

import com.inflearn.toby.helloproject.restapi.HelloRepository;
import com.inflearn.toby.helloproject.restapi.HelloService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE) // 우리가 테스트를 돌릴때는 굳이 웹환경을 셋팅할 필요는 없다
public class HelloServiceCountTest {
    @Autowired
    HelloService helloService;

    @Autowired
    HelloRepository helloRepository;

    @Test
    void satHelloIncreaseCount() {

        IntStream.rangeClosed(1,10).forEach(count -> {

            helloService.sayHello("HyuJik");
            Assertions.assertThat(helloRepository.countOf("HyuJik")).isEqualTo(count);
        });
    }
}
