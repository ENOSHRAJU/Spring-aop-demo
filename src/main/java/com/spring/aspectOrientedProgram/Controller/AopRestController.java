package com.spring.aspectOrientedProgram.Controller;

import com.spring.aspectOrientedProgram.Model.Student;
import com.spring.aspectOrientedProgram.Service.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AopRestController {

    @Autowired
    private AopService service;

    @GetMapping("/students")
    public ArrayList<Student> getPersonDetails() {
        return service.getStudentsData();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student stud) {
        return service.addStudent(stud);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student stud, @PathVariable int id) {
        return service.updateStudent(stud, id);
    }

    @DeleteMapping("/students/{id}")
    public Student deleteStudent(@PathVariable int id) {
        return service.deleteStudent(id);
    }

}
