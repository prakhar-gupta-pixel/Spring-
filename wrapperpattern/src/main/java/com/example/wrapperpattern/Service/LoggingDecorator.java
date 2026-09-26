package com.example.wrapperpattern.Service;


import com.example.wrapperpattern.Entity.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class LoggingDecorator implements StudentService {


    private StudentServiceImpl studentServiceimpl;
    public LoggingDecorator(StudentServiceImpl studentServiceimpl) {
        this.studentServiceimpl = studentServiceimpl;
    }
    @Override
    public void createStudent(Student student) {




        LoggingUtil.logStart("StudentServiceImpl","createStudent");
        studentServiceimpl.createStudent(student);

        LoggingUtil.logEnd("StudentServiceImpl","createStudent");
    }
}
