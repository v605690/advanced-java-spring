package com.codingnomads.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintableAspect {

    @Pointcut(value = "@annotation(com.codingnomads.aspectorientedprogramming.lab.customannotation.Printable)")
    private void printMethod() {}

    @Before("printMethod()")
    public void logBeforePrint(JoinPoint joinPoint) {
        System.out.println("Execute a @Printable method: " + joinPoint.getSignature().getName());
    }

    @After("printMethod()")
    public void logAfterPrint(JoinPoint joinPoint) {
        System.out.println("Finished executing @Printable method: " + joinPoint.getSignature().getName());
    }
}
