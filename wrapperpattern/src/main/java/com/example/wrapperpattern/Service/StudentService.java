package com.example.wrapperpattern.Service;

import com.example.wrapperpattern.Entity.Student;
import org.springframework.stereotype.Component;


@Component
public interface StudentService {

    void createStudent(Student student);
}
