package com.inflearn.toby.helloproject;

import com.inflearn.toby.helloproject.restapi.Hello;
import com.inflearn.toby.helloproject.restapi.HelloDecorate;
import com.inflearn.toby.helloproject.restapi.HelloRepository;
import com.inflearn.toby.helloproject.restapi.SimpleHelloService;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    void simpleHelloService() {
        SimpleHelloService simpleHelloService = new SimpleHelloService(helloRepositoryStub);

        String res = simpleHelloService.sayHello("Test");

        assertThat(res).isEqualTo("helloTest");
    }

    private static HelloRepository helloRepositoryStub = new HelloRepository() {
        @Override
        public Hello findHello(String name) {
            return null;
        }

        @Override
        public void increaseCount(String name) {

        }
    };

    @Test
    void helloDecorator() {
        HelloDecorate decorate = new HelloDecorate(name -> name);

        String res = decorate.sayHello("Test");

        assertThat(res).isEqualTo("*Test*");
    }
}
