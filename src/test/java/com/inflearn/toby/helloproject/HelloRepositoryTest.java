package com.inflearn.toby.helloproject;

import com.inflearn.toby.helloproject.restapi.HelloRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE) // 우리가 테스트를 돌릴때는 굳이 웹환경을 셋팅할 필요는 없다
public class HelloRepositoryTest {
    @Autowired
    HelloRepository helloRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void findHelloFailed(){
        assertThat(helloRepository.findHello("Toby")).isNull();
    }

    @Test
    void increaseCount(){
        assertThat(helloRepository.countOf("Toby")).isEqualTo(0);

        helloRepository.increaseCount("Toby");
        assertThat(helloRepository.countOf("Toby")).isEqualTo(1);

        helloRepository.increaseCount("Toby");
        assertThat(helloRepository.countOf("Toby")).isEqualTo(2);

    }
}
