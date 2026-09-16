package in.strikes.crudSpringBootDemo.Dto.requestdto;

import jakarta.validation.constraints.*;


public class Createrequestdto {


    @NotBlank(message = "Name cannot be null/Empty or blank")
    @Size(min = 2, max = 50, message = "Student name must be within 2 to 50 character long")
    private String Name;

    @NotBlank(message = " Subject  cannot be null/Empty or blank")
    private String Subject;

    @NotNull(message = "Age is required")
    private int Rollno;

    @NotBlank(message = "Student email cannot be blank")
    @Email(message = "Student email must be valid")
    private String Email;



    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Student must be atleast 18 years old")
    private Integer Age;




    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public int getRollno() {
        return Rollno;
    }

    public void setRollno(int rollno) {
        Rollno = rollno;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
