package com.example.wrapperpattern.Service;

import com.example.wrapperpattern.Entity.Student;
import org.springframework.javapoet.ClassName;

public class LoggingUtil {


    public static void logStart(String className, String methodName) {
        System.out.println("executing class: " + className + " method: " + methodName );
    }
    public  static void logEnd(String className, String methodName) {
        System.out.println("executed class: " + className + " method: " + methodName );
    }
}
