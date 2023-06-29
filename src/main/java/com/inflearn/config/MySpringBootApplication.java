package com.inflearn.config;

import com.inflearn.config.EnableMyAutoConfiguration;
import com.inflearn.config.autoconfig.DispatcherServletConfig;
import com.inflearn.config.autoconfig.TomcatWebServerConfig;
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
@EnableMyAutoConfiguration
public @interface MySpringBootApplication {
}
