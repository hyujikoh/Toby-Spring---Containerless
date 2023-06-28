package com.inflearn.toby.helloproject;

import com.inflearn.toby.helloproject.annotation.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

import static org.springframework.boot.SpringApplication.run;

@MySpringBootApplication
public class HelloProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloProjectApplication.class, args);
    }



}
