package in.strikes.crudSpringBootDemo.controller;

import in.strikes.crudSpringBootDemo.Service.StudentService;
import in.strikes.crudSpringBootDemo.Dto.requestdto.Createrequestdto;
import in.strikes.crudSpringBootDemo.Dto.requestdto.Updatereqdto;
import in.strikes.crudSpringBootDemo.Dto.responsedto.Createresponsedto;
import in.strikes.crudSpringBootDemo.Dto.responsedto.Updateresponsedto;
import jakarta.validation.Valid;
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


    @PostMapping()
    public ResponseEntity<Createresponsedto> createStudent(
             @Valid @RequestBody Createrequestdto createrequestdto) {



        Createresponsedto createdStudent = studentService.createStudent(createrequestdto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);


    }



    @GetMapping("/{id}")
    public ResponseEntity<Createresponsedto> getStudent( @PathVariable Long id ) {


         Createresponsedto StudentResponse =studentService.getStudent(id);


         if (StudentResponse == null) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);


                return ResponseEntity.notFound().build();

         }

//         return ResponseEntity.ok(StudentResponse);

            return ResponseEntity.
                    status(HttpStatus.OK).
                    body(StudentResponse);


    }


    @GetMapping()
    public ResponseEntity<List<Createresponsedto>> getAllStudent( ) {


        List<Createresponsedto> StudentResponse = studentService.getAllStudent();




        return ResponseEntity.ok(StudentResponse);
    }


    @PutMapping("/update/{id}")

    public ResponseEntity<Updateresponsedto> updateStudent(@PathVariable Long id,
                                                 @RequestBody Updatereqdto studentreq) {



        Updateresponsedto StudentResponse =studentService.updateStudent(id, studentreq);


        return ResponseEntity.ok(StudentResponse);


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent( @PathVariable Long id ) {
        studentService.deleteStudent(id);



        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();


    }

    @PatchMapping("/delete-soft")
    public ResponseEntity <String> deleteSoftly( @ RequestParam Long id ) {

        studentService.deleteSoftly(id);


        return ResponseEntity.ok("deleted Sucecssfully");


    }



    @PatchMapping("/restore/{id}")

    public ResponseEntity <Createresponsedto> restoreSoftly( @ PathVariable Long id ) {



            Createresponsedto StudentResponse = studentService.restoreSoftly(id);


            if (StudentResponse == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(StudentResponse);
    }


}
