package com.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	@Before("execution(* com.demo.beans.*.m*())")
	public void beforeadvice() {
		System.out.println("Before advice");
	}
	
	@After("execution(* com.demo.beans.*.m*())")
	public void afteradvice() {
		System.out.println("After advicee");
	}

	@Around("execution(* com.demo.beans.*.m*())")
	public Object arroundAdvice(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("in around advice before function call");
		Object obj = jp.proceed();
		System.out.println("In around advice after function call");
		return obj;
	}
}
