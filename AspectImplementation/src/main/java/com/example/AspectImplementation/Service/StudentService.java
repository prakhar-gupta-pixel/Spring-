package com.example.AspectImplementation.Service;


import org.springframework.stereotype.Service;

@Service
public class StudentService {


    public String createStudent()
    {
        System.out.println("Student Saved");

        return "Student Saved";
    }
}
