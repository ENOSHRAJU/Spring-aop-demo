package com.spring.aspectOrientedProgram.Repository;

import com.spring.aspectOrientedProgram.Model.Student;

import java.util.ArrayList;

public interface AopMethodRepo {
    ArrayList<Student> getStudentsData();
    Student getStudentById(int id);
    Student addStudent(Student stud);
    Student updateStudent(Student stud, int id);
    Student deleteStudent(int id);
}
