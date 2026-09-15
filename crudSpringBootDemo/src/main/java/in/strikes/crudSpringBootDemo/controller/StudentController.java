package in.strikes.crudSpringBootDemo.controller;

import in.strikes.crudSpringBootDemo.Service.StudentService;
import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.requestdto.Createrequestdto;
import in.strikes.crudSpringBootDemo.responsedto.Createresponsedto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/students")
public class StudentController {


    private StudentService studentService;


    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }


    @PostMapping("/create")
    public ResponseEntity<Createresponsedto> createStudent(
            @RequestBody Createrequestdto createrequestdto) {



        Createresponsedto createdStudent = studentService.createStudent(createrequestdto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);


    }



    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent( @PathVariable Long id ) {


         Student StudentResponse =studentService.getStudent(id);


         if (StudentResponse == null) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);


                return ResponseEntity.notFound().build();

         }

//         return ResponseEntity.ok(StudentResponse);

            return ResponseEntity.
                    status(HttpStatus.OK).
                    body(StudentResponse);


    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent( ) {


        List<Student> StudentResponse = studentService.getAllStudent();


        if (StudentResponse == null) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);


            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(StudentResponse);
    }


    @PutMapping("/update/{id}")

    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {



        Student StudentResponse =studentService.updateStudent(id, student);


        if (StudentResponse == null) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);


            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(StudentResponse);


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteStudent( @PathVariable Long id ) {
        Boolean isDeleted  =studentService.deleteStudent(id);


        if (!isDeleted) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);


            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(true);


    }

    @PatchMapping("/delete-soft")
    public ResponseEntity <String> deleteSoftly( @ RequestParam Long id ) {

        Boolean isDeleted  =studentService.deleteSoftly(id);


        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }


        return ResponseEntity.ok("deleted Sucecssfully");


    }


}
