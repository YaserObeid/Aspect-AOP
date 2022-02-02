package com.obeid.aopdemo.aspect;



import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
		
		/**
		 * create After_returning advice 
		 * apply it on AccountDAO.findAccounts
		 * annotation parameter:
		 * 		pointcut: Expression
		 * 		returning: list of return values
		 * 
		 * advice parameter:
		 * 		JoinPoint_instance,
		 * 		List<object> (named the same name of returning in annotation)
		 * 		
		 */
		@AfterReturning(
				pointcut = "execution(* com.obeid.aopdemo.dao.AccountDAO.findAccounts())",
				returning = "result"
				)
		public void afterreturningFindAccounts(
				JoinPoint joinPoint, 
				List<Account> result
				) {
			// get the method be advised on
			String method = joinPoint.getSignature().toLongString();
			System.out.println("\n<<<<<<<<<< @Afterreturning on: "+ method);
			System.out.println("<<<<<<<<<< @Afterreturning result: "+ result);
			System.out.println("<<<<<<<<<< @Afterreturning end: ================");
			
			
		}

}
