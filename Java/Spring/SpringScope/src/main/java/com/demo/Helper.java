package com.demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class Helper {
    @Before("execution(public void foo())")
    public void before(){
        System.out.println("before");
    }
    @After("execution(public void foo())")
    public void after(){
        System.out.println("after");
    }
}
