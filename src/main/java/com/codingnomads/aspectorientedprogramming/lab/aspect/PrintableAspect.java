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

    @Pointcut("@annotation(Printable)")
    private void pointCut() {}

    @Before("pointCut()")
    public void logBeforePrint(JoinPoint joinPoint) {
        System.out.println("Execute a @Printable method: " + joinPoint.getSignature().getName());
    }

    @After("pointCut()")
    public void logAfterPrint(JoinPoint joinPoint) {
        System.out.println("Finished executing @Printable method: " + joinPoint.getSignature().getName());
    }
}
