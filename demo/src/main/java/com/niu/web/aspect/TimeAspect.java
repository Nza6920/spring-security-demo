package com.niu.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 描述
 *
 * @author [nza]
 * @version 1.0 2020/9/20
 * @createTime 2020/9/20
 */
//@Aspect
//@Component
public class TimeAspect {

    @Around("execution(* com.niu.web.controller.UserController.*(.. ))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("time aspect start");

        Object object = pjp.proceed();

        System.out.println("time aspect end");

        return object;
    }
}
