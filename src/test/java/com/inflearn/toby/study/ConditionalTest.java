package com.inflearn.toby.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.assertj.core.api.Assertions.*;

public class ConditionalTest {

    @Test
    void conditional(){
        ApplicationContextRunner contextRunner = new ApplicationContextRunner();
        contextRunner.withUserConfiguration(Config1.class)
                .run(context ->{
                    assertThat(context).hasSingleBean(MyBean.class);
                    assertThat(context).hasSingleBean(Config1.class);
                        });

        new ApplicationContextRunner().withUserConfiguration(Config2.class)
                .run(context ->{
                    assertThat(context).doesNotHaveBean(MyBean.class);
                    assertThat(context).doesNotHaveBean(Config2.class);
                });

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Conditional(ConditionalTest.TrueCondition.class)
    @interface TrueConditional{}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Conditional(ConditionalTest.FalseCondition.class)
    @interface FalseConditional{}

    @Configuration
    @TrueConditional
    static class Config1 {
        @Bean
        MyBean myBean(){
            return new MyBean();
        }
    }

    @Configuration
    @FalseConditional
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
