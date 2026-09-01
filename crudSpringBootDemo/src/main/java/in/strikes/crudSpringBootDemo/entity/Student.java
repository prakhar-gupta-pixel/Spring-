package in.strikes.crudSpringBootDemo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {


    @Id
    private Long Id;





    private Boolean deleted;

    private String Name;
    private String Subject;
    private int Rollno;



    private String Email;
    private int Age ;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }


    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public int getRollno() {
        return Rollno;
    }

    public void setRollno(int rollno) {
        this.Rollno = rollno;
    }



    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        this.Subject = subject;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        this.Age = age;
    }


}
