package com.example.demo.student;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;


@Entity
@Table
public class Student {

    @Getter @Setter
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;
    @Getter @Setter
    @Column(name = "student_name")
    private String name;
    @Getter @Setter
    @Column(name = "student_email")
    private String email;
    @Getter @Setter
    @Column(name = "student_dob")
    private LocalDate dob;

    @Transient
    private int age;

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student() {

    }

    public int getAge() {
        return Period.between(dob,LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
