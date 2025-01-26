package com.sagar.relationship;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    private int id;
    private String name;
//    @OneToMany(mappedBy = "student")
//    private List<Laptop> laptop;

    @ManyToMany(mappedBy = "students")
    private List<Laptop> laptops;

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    //    public List<Laptop> getLaptop() {
//        return laptop;
//    }
//
//    public void setLaptop(List<Laptop> laptop) {
//        this.laptop = laptop;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
