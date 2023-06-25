package com.inflearn.toby.helloproject;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloProjectApplication {

    public static void main(String[] args) {
        // 추상화를 진행해서 다른 웹 서버를 사용할 수 있게 설정해야한다.
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            servletContext.addServlet("hello", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
                    res.setStatus(200);
                    res.setHeader("Content-Type","text/plain");
                    res.getWriter().print("Hello Servlet");
                }
            }).addMapping("/hello");
        });
        webServer.start();
    }

}
