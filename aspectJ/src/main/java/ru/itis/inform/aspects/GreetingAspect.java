package ru.itis.inform.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by Timur Mardanov on 07.06.2017.
 * ITIS
 */
@Aspect
public class GreetingAspect {
    public String message;

    public GreetingAspect() {
    }

    public GreetingAspect(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Around("execution(* ru.itis.inform.service.GreetingService.*(..))")
    public Object advice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Aspect beginning");
        String serviceGreeting = (String) proceedingJoinPoint.proceed();
        System.out.println("Aspect ending");
        return message +" and "+ serviceGreeting;
    }
}
