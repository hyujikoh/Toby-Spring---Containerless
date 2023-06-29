package com.inflearn.toby.helloproject.annotation;

import com.inflearn.config.Config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)// 클래스, 인터페이스, enum에게 어로테이션을 줄수있다.
@Configuration
@ComponentScan
@Import(Config.class)
public @interface MySpringBootApplication {
}
