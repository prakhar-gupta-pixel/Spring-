package com.example.AdavncedFilters.Service;

import com.example.AdavncedFilters.Dto.RequestDto;
import com.example.AdavncedFilters.Dto.ResponseDto;
import org.springframework.stereotype.Service;


@Service
public class StudentService {


        public ResponseDto createStudent(RequestDto student) {
           ResponseDto responseDto = new ResponseDto();

           responseDto.setName(student.getName());
           responseDto.setMessage("Stduent is saved successfully");

           return responseDto;
        }
}
