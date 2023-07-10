package com.inflearn.toby.helloproject;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.*;

@HelloBootTest
public class JdbcTemPlateTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void insertAndQuery(){
        jdbcTemplate.update("insert into hello values(?,?)", "Toby",3);
        jdbcTemplate.update("insert into hello values(?,?)", "Spring",3);

        Long count  =jdbcTemplate.queryForObject("select count(*) from hello", Long.class);

        assertThat(count).isEqualTo(2);
    }
    @Test
    void insertAndQuery2(){
        jdbcTemplate.update("insert into hello values(?,?)", "Toby",3);
        jdbcTemplate.update("insert into hello values(?,?)", "Spring",3);

        Long count  =jdbcTemplate.queryForObject("select count(*) from hello", Long.class);

        assertThat(count).isEqualTo(2);
    }
}
