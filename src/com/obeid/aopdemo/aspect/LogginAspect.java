package com.obeid.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
		

		@Aspect
		@Component
		public class LogginAspect {
			
		// will be applied on all methods exclude getter / setter
		
		@Before("com.obeid.aopdemo.aspect.AopExpression.forDaoPackageExeptGetterSetter()")
		public void beforeAddAcount() {
			
			System.out.println("\n loggin @Before excuting!");
		}

}
