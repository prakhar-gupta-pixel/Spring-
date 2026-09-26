package in.Prakhar.filterdemo.Service;


import in.Prakhar.filterdemo.Dto.Student;
import org.springframework.stereotype.Service;

@Service

public class StudentService {

    public void createStudent(Student student) {


        System.out.println("student created");


//        try {
//
//            Thread.sleep(1000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}