package com.spring.aspectOrientedProgram.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "students_data")
public class Student {

    @Id
    @Column(name = "stud_id")
    private int stud_id;

    @Column(name = "stud_name")
    private String stud_name;

    @Column(name = "stud_age")
    private int stud_age;

    @Column(name = "stud_grade")
    private String stud_grade;

    @Column(name = "stud_class")
    private String stud_class;

    public int getStud_id() {
        return stud_id;
    }

    public void setStud_id(int stud_id) {
        this.stud_id = stud_id;
    }

    public String getStud_name() {
        return stud_name;
    }

    public void setStud_name(String stud_name) {
        this.stud_name = stud_name;
    }

    public int getStud_age() {
        return stud_age;
    }

    public void setStud_age(int stud_age) {
        this.stud_age = stud_age;
    }

    public String getStud_grade() {
        return stud_grade;
    }

    public void setStud_grade(String stud_grade) {
        this.stud_grade = stud_grade;
    }

    public String getStud_class() {
        return stud_class;
    }

    public void setStud_class(String stud_class) {
        this.stud_class = stud_class;
    }
}
