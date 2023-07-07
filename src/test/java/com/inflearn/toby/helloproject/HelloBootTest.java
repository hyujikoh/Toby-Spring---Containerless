package com.inflearn.toby.helloproject;

import com.inflearn.config.MyOnClassCondition;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.Conditional;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(SpringExtension.class)// 스프링context 를 이용한 스프링 컨테이너 테스트가 가능하다.
@ContextConfiguration(classes = HelloProjectApplication.class)
@TestPropertySource("classpath:/application.properties")
@Transactional
public @interface HelloBootTest {
}
