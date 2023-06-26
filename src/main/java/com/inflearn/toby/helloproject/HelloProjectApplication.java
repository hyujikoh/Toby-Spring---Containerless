package com.inflearn.toby.helloproject;

import com.inflearn.toby.helloproject.restapi.HelloController;
import com.inflearn.toby.helloproject.restapi.HelloService;
import com.inflearn.toby.helloproject.restapi.SimpleHelloService;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@ComponentScan
public class HelloProjectApplication {

    public static void main(String[] args) {
        // 어노테이션 적용이 가능한 스프링 컨테이너 수정
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext(){
            @Override
            protected void onRefresh() {
                super.onRefresh();
                // 추상화를 진행해서 다른 웹 서버를 사용할 수 있게 설정해야한다.
                ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
                WebServer webServer = serverFactory.getWebServer(servletContext -> {

                    servletContext.addServlet("dispatcherServlet",
                            new DispatcherServlet(this)
                    ).addMapping("/*"); // 해당 요청을 모두 처리하겠다.
                });
                webServer.start();

            }
        };
        // 자바 코드로된 구성 정보를 등록하기 위해 구성정보 클래스 추가
        applicationContext.register(HelloProjectApplication.class);
        applicationContext.refresh();


    }

}
