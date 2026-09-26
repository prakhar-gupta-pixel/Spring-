package com.example.wrapperpattern.Repository;

import com.example.wrapperpattern.Entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public class StudentRepository {


    public void save() {

        System.out.println("Student saved");
    }
}
