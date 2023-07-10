package com.inflearn.toby.helloproject;

import com.inflearn.config.MySpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

import static org.springframework.boot.SpringApplication.run;

@MySpringBootApplication
public class HelloProjectApplication {
    private final JdbcTemplate jdbcTemplate;

    public HelloProjectApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init(){
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

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
