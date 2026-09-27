package com.example.AspectImplementation.Service;


import com.example.AspectImplementation.Dto.Student;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentService {


    public Student createStudent(Student student, UUID req_id) {
        System.out.println("Student Saved");

        throw new RuntimeException("internal eroor");
//     return student;


    }

    public String dummy(String s) {
        return s;
    }
}
