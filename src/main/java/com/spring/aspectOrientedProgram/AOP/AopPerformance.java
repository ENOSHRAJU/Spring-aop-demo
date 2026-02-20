package com.spring.aspectOrientedProgram.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopPerformance {

    private static final Logger LOGGER = LoggerFactory.getLogger(AopPerformance.class);

    // The object contain the method joinpoint result and if it don't return that we won't get the output in postman or to client in general
    @Around("execution(* com.spring.aspectOrientedProgram.Service.AopService.*(..))")
    public Object methodPerformance(ProceedingJoinPoint jp) throws Throwable {

        long start = System.currentTimeMillis();
        Object obj = jp.proceed(); // example if getStudents method is executed then if obj is not returned we wont see students data
        long end = System.currentTimeMillis();

        LOGGER.info("Total time taken: "+ (end-start) + "ms");

        return obj;
    }
}
