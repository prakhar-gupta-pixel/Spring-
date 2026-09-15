    package in.strikes.crudSpringBootDemo.Service;

    import in.strikes.crudSpringBootDemo.entity.Student;
    import in.strikes.crudSpringBootDemo.repository.StudentRepository;
    import in.strikes.crudSpringBootDemo.requestdto.Createrequestdto;
    import in.strikes.crudSpringBootDemo.requestdto.Updatereqdto;
    import in.strikes.crudSpringBootDemo.responsedto.Createresponsedto;
    import in.strikes.crudSpringBootDemo.responsedto.Updateresponsedto;
    import org.springframework.stereotype.Service;
    import org.springframework.web.bind.annotation.RequestParam;

    import java.time.LocalDateTime;
    import java.util.List;
    import java.util.Optional;

    @Service
    public class StudentService {


        private StudentRepository studentRepository;

        public StudentService(StudentRepository studentRepository) {
            this.studentRepository = studentRepository;
        }

        public Createresponsedto createStudent( Createrequestdto createrequestdto) {



            Student student =mapToEntity(createrequestdto);



            Student StudentResp = studentRepository.save(student);



               return mapToDto(StudentResp);
        }



        public Createresponsedto getStudent(Long id) {


            Optional<Student> studentResponse  = studentRepository.findByIdAndDeletedIsFalse(id);


            if(studentResponse.isEmpty())  {
                return null;
            }



            Student studentResp = studentResponse.get();

            return mapToDto(studentResp);
        }

        public List<Createresponsedto> getAllStudent() {


            List<Student> StudentList =studentRepository.findByDeletedIsFalse();


            return StudentList.stream()
                    .map(this::mapToDto)
                    .toList();
        }


        public Updateresponsedto updateStudent(Long id, Updatereqdto studentReq) {
            Optional<Student> existingStudent  = studentRepository.findByIdAndDeletedIsFalse(id);
            if(existingStudent.isEmpty()) {

                return null;
            }


            Student studentToSave = existingStudent.get();/// built in method of optional classs
            studentToSave.setName(studentReq.getName());
            studentToSave.setAge(studentReq.getAge());
            studentToSave.setSubject(studentReq.getSubject());
    //        studentToSave.setDeleted(false);
            studentToSave.setUpdatedAt(LocalDateTime.now());             Student  savedstudent =studentRepository.save(studentToSave);

             return mapToUpdateDto(savedstudent);
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



        private Student mapToEntity(Createrequestdto requestdto) {

            Student StudentResp = new Student();

            StudentResp.setName(requestdto.getName());
            StudentResp.setAge(requestdto.getAge());
            StudentResp.setSubject(requestdto.getSubject());
            StudentResp.setDeleted(false);
            StudentResp.setEmail(requestdto.getEmail());
            StudentResp.setRollno(requestdto.getRollno());
            StudentResp.setCreatedAt(LocalDateTime.now());
            StudentResp.setUpdatedAt(LocalDateTime.now());


            return StudentResp;
        }


        private Createresponsedto mapToDto(Student student){



            Createresponsedto createresponsedto = new Createresponsedto();


            createresponsedto.setEmail(student.getEmail());
            createresponsedto.setName(student.getName());

            createresponsedto.setAge(student.getAge());
            createresponsedto.setSubject(student.getSubject());
            createresponsedto.setId(student.getId());
            createresponsedto.setCreatedAt(student.getCreatedAt());
            createresponsedto.setUpdatedAt(student.getUpdatedAt());
            createresponsedto.setMessage("created sucessfully");


            return  createresponsedto;
        }


         private Updateresponsedto mapToUpdateDto(Student student){

             Updateresponsedto updateresponsedto = new Updateresponsedto();



             updateresponsedto.setEmail(student.getEmail());

             updateresponsedto.setName(student.getName());

             updateresponsedto.setAge(student.getAge());
             updateresponsedto.setSubject(student.getSubject());
             updateresponsedto.setId(student.getId());
             updateresponsedto.setCreatedAt(student.getCreatedAt());
             updateresponsedto.setUpdatedAt(student.getUpdatedAt());

             updateresponsedto.setMessage("updated sucessfully");
             return  updateresponsedto;

         }


    }
