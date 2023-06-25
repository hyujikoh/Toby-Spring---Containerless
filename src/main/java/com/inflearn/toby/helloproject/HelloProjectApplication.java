package com.inflearn.toby.helloproject;

import com.inflearn.toby.helloproject.restapi.HelloController;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

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
            HelloController helloController = new HelloController();

            servletContext.addServlet("frontcontroller", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
                    // 인증, 보안, 다국어, 공통 기능을 처리
                    if(req.getRequestURI().equals("/hello")&&req.getMethod().equals(HttpMethod.GET.name())){
                        String name = req.getParameter("name");

                        String ret = helloController.hello(name);

                        res.setStatus(HttpStatus.OK.value());
                        res.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
                        res.getWriter().print(ret);
                    }
                    else if (req.getRequestURI().equals("/user")){}
                    else res.setStatus(HttpStatus.NOT_FOUND.value());
                }
            }).addMapping("/*"); // 해당 요청을 모두 처리하겠다.
        });
        webServer.start();
    }

}
