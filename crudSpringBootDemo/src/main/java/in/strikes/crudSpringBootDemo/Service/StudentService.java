package in.strikes.crudSpringBootDemo.Service;

import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.repository.StudentRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent( Student studentReq) {

//        System.out.println("entering serivce");

        studentReq.setDeleted(false);
        Student StudentResp = studentRepository.save(studentReq);

        System.out.println("exiting serivce");

           return StudentResp;
    }



    public Student getStudent(Long id) {


        Optional<Student> studentResponse  = studentRepository.findByIdAndDeletedIsFalse(id);


        if(studentResponse.isEmpty())  {
            return null;
        }



        return studentResponse.get();
    }

    public List<Student> getAllStudent() {


        List<Student> StudentResponse =studentRepository.findByDeletedIsFalse();


        return StudentResponse;
    }


    public Student updateStudent(Long id, Student studentReq) {
        Optional<Student> existingStudent  = studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()) {

            return null;
        }


        Student studentToSave = existingStudent.get();/// built in method of optional classs
        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setDeleted(false);
         studentRepository.save(studentToSave);

         return studentToSave;
    }

    public Boolean deleteStudent(Long id) {

        Boolean isStudent = studentRepository.existsById(id);

        if(!isStudent) {
            return false;
        }


        studentRepository.deleteById(id);

        return isStudent;
    }



    public Boolean deleteSoftly(@RequestParam Long Id) {

        Optional<Student> existingStudent  = studentRepository.findByIdAndDeletedIsFalse(Id);

        if(existingStudent.isEmpty()) {
            return false;

        }

         Student studentToSave = existingStudent.get();

        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);


        return true;
    }
}
