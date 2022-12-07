package jp.ac.ccmc.employeedemo.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "employee_demo")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "email", length = 200)
    private String email;

    @Column(name = "gender")
    private String gender;

    public Employee() {
    }

    public Employee(String name, String email, String gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
}
