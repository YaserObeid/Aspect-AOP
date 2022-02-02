package com.obeid.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


		@Aspect
		@Component
		@Order(50)
		public class CloudLogAsyncAspect {
			
		// will be applied on all methods exclude getter / setter
		
		@Before("com.obeid.aopdemo.aspect.AopExpression.forDaoPackageExeptGetterSetter()")
		public void logToCoud() {
			
			System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>> logToCoud @Before excuting!");
		}

}
