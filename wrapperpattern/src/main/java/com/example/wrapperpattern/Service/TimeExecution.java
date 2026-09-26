package com.example.wrapperpattern.Service;

import com.example.wrapperpattern.Entity.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.sql.Time;

@Component

@Primary
public class TimeExecution implements StudentService
{

    private LoggingDecorator loggingDecorator;
    public TimeExecution(LoggingDecorator loggingDecorator) {
        this.loggingDecorator = loggingDecorator;
    }


    @Override
    public void createStudent(Student student) {


        long start= System.currentTimeMillis();

        loggingDecorator.createStudent(student);
        long end= System.currentTimeMillis();

        System.out.println("Time taken: " + (end-start));

    }
}
