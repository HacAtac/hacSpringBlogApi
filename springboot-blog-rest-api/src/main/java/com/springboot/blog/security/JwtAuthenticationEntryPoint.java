package com.springboot.blog.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());

    }
}
//Steps of adding JWT Authentication to Spring Boot REST API using Spring Security
//1. Adding JWT Dependency to the pom.xml
//2. Create JwtAuthenticationEntryPoint class
//3. Add jwt properties in application.properties file
//4. Create JwtTokenProvider class
//5. Craete JwtAuthenticationFilter class
//6. Create JWTAuthResponse DTO class
//7. Configure JWT in Spring Security Configuration class
//8. Change the REST API's that will be secured by JWT