package in.strikes.crudSpringBootDemo.repository;


import in.strikes.crudSpringBootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long > {
    Optional<Student> findByIdAndDeletedIsFalse(Long id);

    List<Student> findByDeletedIsFalse();




//        System.out.println("entering repository");
//
//        Student s1 = new Student();
//        s1.setName("gregerg");
//
//        s1.setAge(30);
//        s1.setEmail("dvwegwefg@gmial.com");
//        s1.setSubject("Maths");
//        System.out.println("exiting repo");


}
