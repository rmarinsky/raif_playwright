package io.testomat.common.aspects;

import io.qameta.allure.Step;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AllureAspect {

    @Pointcut("execution(* common.pw..*(..))")
    public void methodsInCommonPwPackage() {
    }

    @Pointcut("@annotation(step)")
    public void callAt(Step step) {
    }

    @Around(value = "callAt(step) && methodsInCommonPwPackage()", argNames = "point,step")
    public Object around(ProceedingJoinPoint point, Step step) throws Throwable {
        // executed before the method
        System.out.println("Before method: " + step.value());

        Object result = null;

        try {
            result = point.proceed();
        } catch (Exception e) {
            // handle exception
            System.out.println(e.getMessage());
        } finally {
            // executed after the method (in case of both success and exception)
            System.out.println("After method: " + step.value());
        }

        return result;
    }

}
