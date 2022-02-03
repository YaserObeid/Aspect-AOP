package com.obeid.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



		@Aspect
		@Component
		@Order(3)
		public class CloudLogAsyncAspect {
			
			private static Logger myLogger = 
					Logger.getLogger(CloudLogAsyncAspect.class.getName());
			
		// will be applied on all methods exclude getter / setter
		
		@Before("com.obeid.aopdemo.aspect.AopExpression.forDaoPackageExeptGetterSetter()")
		public void logToCoud(JoinPoint joinPoint) {
			String method = joinPoint.getSignature().toLongString();
			myLogger.info("\n>>>>>>>>>> @Before (2- LOG Cloud) on: "+ method);
			myLogger.info("<<<<<<<<<< @Before end  ");
		}

}
