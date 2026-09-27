package com.example.AspectImplementation.Aspect;


import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private HttpServletRequest request;
    public LoggingAspect(HttpServletRequest request) {

        this.request = request;
    }

    @Before( "execution(String com.example.AspectImplementation.Service.StudentService.createStudent())")
    public void logBeore(){

        String auth =  request.getHeader("Authorization");

        if (!auth.equals("Admin")) {

            throw new RuntimeException("Unauthorized");

        }
        System.out.println("log before called as admin called this method");
    }
}
