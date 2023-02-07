package role.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Actor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 2, max = 30)
    @Column(length = 30,nullable = false)
    private String firstName;
    @Size(min = 2, max = 30)
    @Column(length = 30,nullable = false)
    private String lastName;
    @Size(min = 2, max = 30)
    @Column(length = 30,nullable = false)
    private String nationality;
    @Min(1)
    @Max(100)
    @Column(length = 3)
    private int age;
    private Gender gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
