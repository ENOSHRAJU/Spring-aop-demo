package com.spring.aspectOrientedProgram.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // This method executes before the joinpoint method get executed.
    @Before("execution(* com.spring.aspectOrientedProgram.Service.AopService.*(..))")  
    public void logMethodCalled(JoinPoint jp) {
        LOGGER.info("Method called {}", jp.getSignature().getName());
    }

    // This method executes no matter the joinpoint method does
    @After("execution(* com.spring.aspectOrientedProgram.Service.AopService.*(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("Method Executed: "+ jp.getSignature().getName());
    }

    // This method only executes when there is an error with the joinpoint method.
    @AfterThrowing("execution(* com.spring.aspectOrientedProgram.Service.AopService.*(..))")
    public void logMethodError(JoinPoint jp) {
        LOGGER.info("Method didn't get executed because of an error "+ jp.getSignature().getName());
    }

    // This method executes only if there no error in joinpoint
    @AfterReturning("execution(* com.spring.aspectOrientedProgram.Service.AopService.*(..))")
    public void logMethodExcutedSucessfully(JoinPoint jp) {
        LOGGER.info("Method executed with no errors: "+ jp.getSignature().getName());
    }

}
