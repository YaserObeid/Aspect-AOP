package com.obeid.aopdemo.aspect;


import java.util.Iterator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.obeid.aopdemo.Account;
		

		@Aspect
		@Component
		@Order(2)
		public class LogginAspect {
			/**
			 * you can access meta data of the target method:
			 * 
			 */
			
		
		
		@Before("com.obeid.aopdemo.aspect.AopExpression.forDaoPackageExeptGetterSetter()")
		// 1- pass joinpoint_instance as parameter
		public void beforeAddAcount(JoinPoint joinPoint) {
			
			System.out.println("\n loggin @Before excuting!");
			
			
			// display method signature using the passed joinpoint
			MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
			
			System.out.println("Method signature: "+ methodSignature);
			
			// display the method arguments
			
			Object[] args = joinPoint.getArgs();
			
			for(Object o : args) {
				
				System.out.println("arg: "+ o );
				if( o instanceof Account) {
					Account account = (Account) o;
					System.out.println("accoun name: "+ account.getName());
					System.out.println("accoun level: "+ account.getLevel());
				}
			}
			
			
			
			
			
			
			
		}

}
