/* CodingNomads (C)2024 */
package com.codingnomads.aspectorientedprogramming.aop.aspect;

import com.codingnomads.aspectorientedprogramming.aop.service.StudentService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAspect.class);

    @Pointcut(value = "execution(* com.codingnomads.aspectorientedprogramming.aop.service.StudentService.saveStudent(..))")
    private void logAllStudentServiceMethods() {}

    @Before("execution(* com.codingnomads.aspectorientedprogramming.aop.service.StudentService.saveStudent(..))")
    public void logSaveStudent(JoinPoint joinPoint) {
        LOGGER.info("Starting to save student: " + joinPoint.getSignature());
    }

    @After("execution(* com.codingnomads.aspectorientedprogramming.aop.service.StudentService.saveStudent())")
    public void logSaveStudentMethodCompleted(JoinPoint joinPoint) {
        LOGGER.info("New Student saved: " + joinPoint.getSignature().getName());
    }

    @Before("logAllStudentServiceMethods()")
    public void logBeforeAdvice(JoinPoint joinPoint) {
        LOGGER.info("Before Advice : " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.codingnomads.aspectorientedprogramming.aop.service.StudentService.fetchAllStudents())")
    public void logFetchAllStudentMethod(JoinPoint joinPoint) {
        // write any custom logic according to business requirement
        LOGGER.info("Before the execution of : " + joinPoint.getSignature());
    }

    @After("logAllStudentServiceMethods()")
    public void logAfterAdvice(JoinPoint joinPoint) {
        LOGGER.info("After Advice: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "logAllStudentServiceMethods()", returning = "students")
    public void afterReturningAdvice(JoinPoint jp, Object students) {
        LOGGER.info("After Returning Advice: " + " Method Name: = "
                + jp.getSignature().getName());
        LOGGER.info("Result: = " + students);
    }
}
