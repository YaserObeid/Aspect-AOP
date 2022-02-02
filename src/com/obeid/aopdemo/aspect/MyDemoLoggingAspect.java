package com.obeid.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {
	
	/**
	 *  declare a new pointcut to apply advice
	 *  on all methods in package DAO
	 *  can have any name
	 *  
	 */
	
	@Pointcut("execution(* com.obeid.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// apply the declared pointcut on this advice
	
	@Before("forDaoPackage()")
	public void beforeAddAccount() {
		
		System.out.println("\n>>>>>>>>>>>>>>> @Before Aaading account");
	}
}
