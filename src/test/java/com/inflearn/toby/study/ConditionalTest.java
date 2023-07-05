package com.inflearn.toby.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConditionalTest {

    @Test
    void conditional(){

        // true
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(Config1.class);
        ac.refresh();

        MyBean myBean = ac.getBean(MyBean.class);
        //false
        AnnotationConfigWebApplicationContext ac2 = new AnnotationConfigWebApplicationContext();
        ac2.register(Config2.class);
        ac2.refresh();

        MyBean myBean2 = ac2.getBean(MyBean.class);
    }

    @Configuration
    @Conditional(ConditionalTest.TrueCondition.class)
    static class Config1 {
        @Bean
        MyBean myBean(){
            return new MyBean();
        }
    }

    @Configuration
    @Conditional(ConditionalTest.FalseCondition.class)
    static class Config2 {
        @Bean
        MyBean myBean(){
            return new MyBean();
        }
    }

    static class MyBean{

    }

    static class TrueCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return true;
        }
    }

    static class FalseCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return false;
        }
    }
}
