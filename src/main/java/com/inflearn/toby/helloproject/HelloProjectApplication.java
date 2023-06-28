package com.inflearn.toby.helloproject;

import com.inflearn.toby.helloproject.annotation.MySpringBootAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import static org.springframework.boot.SpringApplication.run;

@MySpringBootAnnotation
public class HelloProjectApplication {
    @Bean
    public ServletWebServerFactory servletWebServerFactory(){
        return new TomcatServletWebServerFactory();
    }

    @Bean
    public DispatcherServlet dispatcherServlet(){
        return new DispatcherServlet();
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloProjectApplication.class, args);
    }



}
