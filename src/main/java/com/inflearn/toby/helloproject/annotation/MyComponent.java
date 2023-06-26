package com.inflearn.toby.helloproject.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // 대상 지정 클래스와 같은 타입에만 들어갈수 있다.
@Retention(RetentionPolicy.RUNTIME) // 언제까지 살아있을것인가
@Component
public @interface MyComponent {
}
