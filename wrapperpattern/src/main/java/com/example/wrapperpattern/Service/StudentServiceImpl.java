package com.example.wrapperpattern.Service;

import com.example.wrapperpattern.Entity.Student;
import com.example.wrapperpattern.Repository.StudentRepository;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {


    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentrepository) {
        this.studentRepository = studentrepository;
    }


    @Override
    public void createStudent(Student student)
    {
        studentRepository.save();

    }



}
