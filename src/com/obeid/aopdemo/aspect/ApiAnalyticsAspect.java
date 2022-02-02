package com.obeid.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
		

		@Aspect
		@Component
		@Order(1)
		public class ApiAnalyticsAspect {
			/**
			 * Aspect order using @Order(int a)	
			 * a can be negative , 0 , positive
			 * lowest value -> higher priority
			 * Order(-50) ->  * Order(-1) ->  * Order(5) -> ....
			 */
			
		// will be applied on all methods exclude getter / setter
		// com.obeid.aopdemo.aspect.AopExpression: qualified name of expression source
		@Before("com.obeid.aopdemo.aspect.AopExpression.forDaoPackageExeptGetterSetter()")
		public void performApiAnalys() {
			
			System.out.println("\n analys perform @Before excuting!");
		}

}
