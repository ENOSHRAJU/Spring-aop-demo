package com.spring.aspectOrientedProgram.Repository;

import com.spring.aspectOrientedProgram.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AopRepository extends JpaRepository<Student, Integer> {

}
