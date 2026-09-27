package com.example.AspectImplementation.Controller;


    import com.example.AspectImplementation.Dto.Student;
    import com.example.AspectImplementation.Service.StudentService;
    import jakarta.servlet.http.HttpServletRequest;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/api/students")
    public class StudentController {



        private StudentService studentService;
        public StudentController(StudentService studentService) {
            this.studentService = studentService;
        }



        @PostMapping
        public ResponseEntity<String> createStudent(@RequestBody Student student) {

            String s = studentService.createStudent();


            return ResponseEntity.ok(s);
        }



    }
