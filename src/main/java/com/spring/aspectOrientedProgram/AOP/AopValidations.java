package com.spring.aspectOrientedProgram.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class AopValidations {

    private static final Logger LOGGER = LoggerFactory.getLogger(AopValidations.class);

    @Around("execution(* com.spring.aspectOrientedProgram.Service.AopService.getStudentById(..)) && args(stud_id)")
    public Object methodValidations(ProceedingJoinPoint jp, int stud_id) throws Throwable {
        LOGGER.info("Student id is: "+ stud_id);

        if(stud_id < 0) {
            stud_id = -(stud_id);
        }

        return jp.proceed(new Object[]{stud_id});
    }
}
