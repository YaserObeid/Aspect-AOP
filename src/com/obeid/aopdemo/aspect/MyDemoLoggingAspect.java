package com.obeid.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {
		
	// all looin_advices
	
	// beforeAdvice
	/*
	 * Pointcut Expression
	 * "execution(public void com.obeid.aopdemo.dao.MembershipDAO.addAccount())"
	 * "execution(public void addAccount())"
	 * "execution(public void add*())"
	 * "execution(public * add*())"
	 * "execution(* add*())"
	 * "execution(void *())"
	 * "execution(void *())" - no parameter
	 * "execution(void *(*))" - one parameter any type
	 * "execution(void *(..))" - no, one or many parameter any type
	 * 
	 * "execution(* com.obeid.aopdemo.dao.*.*(..))"->
	 *  MAtch all methods in a package com.obeid.aopdemo.dao
	 *  
	 *  "execution(void add*(com.obeid.aopdemo.Account, ..))") ->
	 *  Match all methods its name begins with add & has parameter from type Account
	 *  
	 *  "execution(void add*(com.obeid.aopdemo.Account, ..))") ->
	 *  Match all methods its name begins with add & 
	 *  has parameter from type Account &
	 *  any number of parameter
	 */
	
	// method apply before execution all method match:  
	// the given pointcut expression
	@Before("execution(* com.obeid.aopdemo.dao.*.*(..))")
	public void beforeAddAccount() {
		
		System.out.println("\n>>>>>>>>>>>>>>> @Before Aaading account");
	}
}
