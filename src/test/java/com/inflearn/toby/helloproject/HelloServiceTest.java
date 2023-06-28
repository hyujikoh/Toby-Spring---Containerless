package com.inflearn.toby.helloproject;

import com.inflearn.toby.helloproject.restapi.HelloDecorate;
import com.inflearn.toby.helloproject.restapi.SimpleHelloService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FastUnitTest{}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD})
@Test
@interface UnitTest{

}
class HelloServiceTest {

    @UnitTest
    void simpleHelloService() {
        SimpleHelloService simpleHelloService = new SimpleHelloService();

        String res = simpleHelloService.sayHello("Test");

        assertThat(res).isEqualTo("helloTest");
    }

    @Test
    void helloDecorator() {
        HelloDecorate decorate = new HelloDecorate(name -> name);

        String res = decorate.sayHello("Test");

        assertThat(res).isEqualTo("*Test*");
    }
}
