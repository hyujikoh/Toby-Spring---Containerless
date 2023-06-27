package com.inflearn.toby.helloproject.restapi;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class HelloServiceTest {

    @Test
    void simpleHelloService() {
        SimpleHelloService simpleHelloService = new SimpleHelloService();

        String res = simpleHelloService.sayHello("Test");

        assertThat(res).isEqualTo("helloTest");
    }
}
