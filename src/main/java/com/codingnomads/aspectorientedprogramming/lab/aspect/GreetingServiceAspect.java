/* CodingNomads (C)2024 */
package com.codingnomads.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServiceAspect {

    @Pointcut(value = "execution(* com.codingnomads.aspectorientedprogramming.lab.service.GreetingService.greeting(..))")
    private void greetingMethod() {}

    @Pointcut(value = "execution(* com.codingnomads.aspectorientedprogramming.lab.service.GreetingService.greetByName(..))")
    private void greetingMethodByName() {}

    @Before("greetingMethod()")
    public void logBeforeGreeting(JoinPoint joinPoint) {
        System.out.println("Before greeting method execution: " + joinPoint.getSignature());
    }

    @Before("greetingMethodByName()")
    public void logBeforeGreetingName(JoinPoint joinPoint) {
        System.out.println("Before greeting method  by name execution: " + joinPoint.getSignature());
    }

    @AfterReturning("greetingMethod()")
    public void logAfterReturning(JoinPoint joinPoint) {
        System.out.println("After Returning");
    }

    @After("greetingMethod()")
    public void logAfterGreeting(JoinPoint joinPoint) {
        System.out.println("After greeting method execution: " + joinPoint.getSignature().getName());
    }
    @After("greetingMethodByName()")
    public void logAfterGreetingByName(JoinPoint joinPoint) {
        System.out.println("After greeting method by name execution: " + joinPoint.getSignature().getName());
    }



}
