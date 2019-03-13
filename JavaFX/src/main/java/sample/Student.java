package sample;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column (name = "id")
    private Integer id;

    @Column (name = "firstname")
    private String firstname;

    @Column (name = "lastname")
    private String lastname;


    public Student() {
    }

    public Student(String firstname, String lastname) {
      setFirstname(firstname);
      setLastname(lastname);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    @Override
    public String toString() {
        return "entities.Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
