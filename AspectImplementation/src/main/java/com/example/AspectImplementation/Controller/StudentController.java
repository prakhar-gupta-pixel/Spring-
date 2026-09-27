package com.example.AspectImplementation.Controller;


    import com.example.AspectImplementation.Dto.Student;
    import com.example.AspectImplementation.Service.StudentService;
    import jakarta.servlet.http.HttpServletRequest;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.UUID;

@RestController
    @RequestMapping("/api/students")
    public class StudentController {



        private StudentService studentService;
        public StudentController(StudentService studentService) {
            this.studentService = studentService;
        }



        @PostMapping
        public ResponseEntity<Student> createStudent(@RequestBody Student student) {

            UUID uuid = UUID.randomUUID();
            Student s = studentService.createStudent(student ,uuid);


            return ResponseEntity.ok(s);
        }



    @GetMapping
    public ResponseEntity<String> dummy()
    {


        String s = "aditya";
        return ResponseEntity.ok(studentService.dummy(s));
    }

    }
