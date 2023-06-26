package com.inflearn.toby.helloproject.restapi;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {
    public static void run(Class<?> applicationClass, String[] args){
        // 어노테이션 적용이 가능한 스프링 컨테이너 수정
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext(){
            @Override
            protected void onRefresh() {
                super.onRefresh();
                // 추상화를 진행해서 다른 웹 서버를 사용할 수 있게 설정해야한다.
                ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);

                WebServer webServer = serverFactory.getWebServer(servletContext -> {

                    servletContext.addServlet("dispatcherServlet",
                            new DispatcherServlet(this)
                    ).addMapping("/*"); // 해당 요청을 모두 처리하겠다.
                });
                webServer.start();

            }
        };
        // 자바 코드로된 구성 정보를 등록하기 위해 구성정보 클래스 추가
        applicationContext.register(applicationClass);
        applicationContext.refresh();

    }
}
