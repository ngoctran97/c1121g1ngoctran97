package com.codegym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.xml.ws.soap.Addressing;
import java.util.Arrays;

@Component
@Aspect
public class MuonAspect {
    @AfterReturning(pointcut = "execution(public * com.codegym.controller.MuonController.index(..))")
    public void log(JoinPoint joinPoint, Exception e) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.err.println("Method name: " + methodName);
        System.err.println("Args: " + args);
    }
}
