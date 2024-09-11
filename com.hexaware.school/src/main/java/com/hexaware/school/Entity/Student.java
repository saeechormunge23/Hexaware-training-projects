package com.hexaware.school.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private int Rollno;
    private String Name;
    private Double Fee;

    public Student() {
        // No-argument constructor required by JPA
    }

    public Student(int rollno, String name, Double fee) {
        this.Rollno = rollno;
        this.Name = name;
        this.Fee = fee;
    }

    // Getters and setters

    public int getRollno() {
        return Rollno;
    }

    public void setRollno(int rollno) {
        this.Rollno = rollno;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Double getFee() {
        return Fee;
    }

    public void setFee(Double fee) {
        this.Fee = fee;
    }

    @Override
    public String toString() {
        return "Student [Rollno=" + Rollno + ", Name=" + Name + ", Fee=" + Fee + "]";
    }
}
