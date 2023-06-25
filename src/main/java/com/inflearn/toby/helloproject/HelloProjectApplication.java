package com.inflearn.toby.helloproject;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

public class HelloProjectApplication {

    public static void main(String[] args) {
        // 추상화를 진행해서 다른 웹 서버를 사용할 수 있게 설정해야한다.
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer();
        webServer.start();
    }

}
