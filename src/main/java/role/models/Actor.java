package role;

import javax.persistence.*;
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
    private String nationality;
    private int age;
    private Gender gender;
}
