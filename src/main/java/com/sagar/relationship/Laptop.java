package com.sagar.relationship;

import javax.persistence.*;
import java.util.List;

@Entity
public class Laptop {

    @Id
    private int id;
    private String brand;
//    @ManyToOne
//    private Student student;

    @ManyToMany
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    //    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
