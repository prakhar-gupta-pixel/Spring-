    package in.strikes.crudSpringBootDemo.Service;

    import in.strikes.crudSpringBootDemo.Exception.ResourceNotFoundException;
    import in.strikes.crudSpringBootDemo.entity.Student;
    import in.strikes.crudSpringBootDemo.repository.StudentRepository;
    import in.strikes.crudSpringBootDemo.requestdto.Createrequestdto;
    import in.strikes.crudSpringBootDemo.requestdto.Updatereqdto;
    import in.strikes.crudSpringBootDemo.responsedto.Createresponsedto;
    import in.strikes.crudSpringBootDemo.responsedto.Updateresponsedto;
    import org.springframework.http.ResponseEntity;
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



            if(emailExists(student)){

                throw new ResourceNotFoundException("Email" + student.getEmail()+ "already exists");
            }

            Student StudentResp = studentRepository.save(student);



               return mapToDto(StudentResp);
        }



        public Createresponsedto getStudent(Long id) {


             Student studentResp = studentRepository
                    .findByIdAndDeletedIsFalse(id)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Student with id " + id +" not found"));// if not handle heere we willl get generic response





//            if(studentResponse.isEmpty())  {
//                return null;
//            }



//            Student studentResp = studentResponse.get();
//
            return mapToDto(studentResp);
        }

        public List<Createresponsedto> getAllStudent() {


            List<Student> StudentList =studentRepository.findByDeletedIsFalse();


            return StudentList.stream()
                    .map(this::mapToDto)
                    .toList();
        }


        public Updateresponsedto updateStudent(Long id, Updatereqdto studentReq) {
            Student existingStudent  = studentRepository.
                    findByIdAndDeletedIsFalse(id)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Student with id " + id +" not found"));


            existingStudent.setName(studentReq.getName());
            existingStudent.setAge(studentReq.getAge());
            existingStudent.setSubject(studentReq.getSubject());

            existingStudent.setUpdatedAt(LocalDateTime.now());             Student  savedstudent =studentRepository.save(existingStudent);

             return mapToUpdateDto(savedstudent);
        }

        public void deleteStudent(Long id) {

            Student StudenttobeDeleted = studentRepository
                    .findById(id)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Student with id " + id +" not found"));





            studentRepository.delete(StudenttobeDeleted);


        }



        public void deleteSoftly(@RequestParam Long Id) {

            Student StudenttobeDeleted = studentRepository
                    .findById(Id)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Student with id " + Id +" not found"));





             Student studentToSave = StudenttobeDeleted;

            studentToSave.setDeleted(true);
            studentRepository.save(studentToSave);


        }

        public Createresponsedto restoreSoftly(Long Id) {

           Optional<Student> StudentResponse = studentRepository.findByIdAndDeletedIsTrue(Id);

            if (StudentResponse.isEmpty()) {
                return null;
            }

            Student studentResp = StudentResponse.get();

            studentResp.setDeleted(false);
            studentRepository.save(studentResp);

            return mapToDto(studentResp);


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


         private Boolean emailExists(Student student){

           return  studentRepository.existsByEmail(student.getEmail());
         }


    }
