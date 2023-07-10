package com.inflearn.toby.helloproject;

import com.inflearn.toby.helloproject.restapi.HelloRepository;
import com.inflearn.toby.helloproject.restapi.HelloService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.IntStream;

@HelloBootTest
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
