package com.inflearn.toby.helloproject;

import com.inflearn.config.MySpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import static org.springframework.boot.SpringApplication.run;

@MySpringBootApplication
public class HelloProjectApplication {

    @Bean
    ApplicationRunner applicationRunner(Environment env){
        return args -> {
            String name = env.getProperty("my.name");
            System.out.println("my.name" + name);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloProjectApplication.class, args);
    }
}
