package com.obeid.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


		@Aspect
		@Component
		public class ApiAnalyticsAspect {
			
		// will be applied on all methods exclude getter / setter
		
		@Before("com.obeid.aopdemo.aspect.AopExpression.forDaoPackageExeptGetterSetter()")
		public void performApiAnalys() {
			
			System.out.println("\n analys perform @Before excuting!");
		}

}
