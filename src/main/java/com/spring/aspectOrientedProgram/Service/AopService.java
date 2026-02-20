package com.spring.aspectOrientedProgram.Service;

import com.spring.aspectOrientedProgram.Model.Student;
import com.spring.aspectOrientedProgram.Repository.AopMethodRepo;
import com.spring.aspectOrientedProgram.Repository.AopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Service
public class AopService implements AopMethodRepo {

    @Autowired
    private JdbcTemplate db;

    @Autowired
    private AopRepository repository;

    @Override
    public ArrayList<Student> getStudentsData() {
        return new ArrayList<>(repository.findAll());
    }

    @Override
    public Student getStudentById(int id) {

        try {
            return repository.findById(id).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Student addStudent(Student stud) {
        repository.save(stud);
        return stud;
    }

    @Override
    public Student updateStudent(Student stud, int id) {
        try {
            Student temp = repository.findById(id).get();
            if(stud.getStud_id() <= 0) {
                temp.setStud_id(id);
            }
            if(stud.getStud_name() != null) {
                temp.setStud_name(stud.getStud_name());
            }
            if(stud.getStud_age() > 0) {
                temp.setStud_age(stud.getStud_age());
            }
            if(stud.getStud_grade() != null) {
                temp.setStud_grade(stud.getStud_grade());
            }
            if(stud.getStud_class() != null) {
                temp.setStud_class(stud.getStud_class());
            }

            repository.save(temp);
            return temp;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Student deleteStudent(int id) {
        try {
            Student temp = repository.findById(id).get();
            repository.deleteById(id);
            return temp;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
