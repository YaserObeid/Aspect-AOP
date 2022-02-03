package com.obeid.aopdemo.aspect;



import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.obeid.aopdemo.Account;
		

		@Aspect
		@Component
		@Order(2)
		public class LogginAspect {
			
			private static Logger myLogger = 
					Logger.getLogger(LogginAspect.class.getName());
			
			/**
			 * you can access meta data of the target method:
			 * 
			 */
			
		@Before("com.obeid.aopdemo.aspect.AopExpression.forDaoPackageExeptGetterSetter()")
		// 1- pass joinpoint_instance as parameter
		public void beforeAddAcount(JoinPoint joinPoint) {
			String method = joinPoint.getSignature().toLongString();
			myLogger.info("\n>>>>>>>>>> @Before (2- loggin) on: "+ method);
			
			// display the method arguments
			
			Object[] args = joinPoint.getArgs();
			
			for(Object o : args) {
				
				myLogger.info("arg: "+ o );
				if( o instanceof Account) {
					Account account = (Account) o;
					myLogger.info("accoun name: "+ account.getName());
					myLogger.info("accoun level: "+ account.getLevel());
				}
			}
			myLogger.info("<<<<<<<<<< @Before end  ");
		
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
		 * you can modify the return data before the caller receive it !!!	
		 */
		@AfterReturning(
				pointcut = "execution(* com.obeid.aopdemo.dao.AccountDAO.findAccounts(..))",
				returning = "result"
				)
		public void afterreturningFindAccounts(
				JoinPoint joinPoint, 
				List<Account> result
				) {
			// get the method be advised on
			String method = joinPoint.getSignature().toLongString();
			myLogger.info("\n<<<<<<<<<< @AfterReturning on: "+ method);
			myLogger.info("<<<<<<<<<< @AfterReturning result: "+ result);
			
			
			// let's post_process the data : convert name to Upper case
			for(Account account: result) {
				account.setName(account.getName().toUpperCase());
			}
			myLogger.info("<<<<<<<<<< @AfterReturning convert name to upper");
			myLogger.info("<<<<<<<<<< @AfterReturning end");
			
			
		}
		
		/**
		 * AfterThrowing advice is executed if 
		 * an exception is thrown
		 * return an exception object
		 * the exception go on normal
		 * it doesn't handle the exception
		 */
		@AfterThrowing(
				pointcut = "execution(* com.obeid.aopdemo.dao.AccountDAO.findAccounts(..))",
				throwing = "ex"
				)
		public void afterThrowingAdviceFindAccounts(
				JoinPoint joinPoint,
				Throwable ex
				) {
			// get the method be advised on
				String method = joinPoint.getSignature().toLongString();
				myLogger.info("\n<<<<<<<<<< @AfterThrowing on: "+ method);
				myLogger.info("<<<<<<<<<< @AfterThrowing ex : "+ ex);
				myLogger.info("<<<<<<<<<< @AfterThrowing End  ");
			
			
		}
		
		/**
		 * After advice is executed at any case : fail/ success
		 * return no values or exception
		 * it is executed before AfterReturn / AfterThrowing
		 * 
		 */
		@After("execution(* com.obeid.aopdemo.dao.AccountDAO.findAccounts(..))")
		public void afterFinallyFindAccounts(JoinPoint joinPoint) {
			
			// get the method be advised on
			String method = joinPoint.getSignature().toLongString();
			myLogger.info("\n<<<<<<<<<< @After (finally) on: "+ method);
			myLogger.info("<<<<<<<<<< @After (finally) end  ");
		}
		
		
		
		/**
		 * Around Advice execute before & after the target
		 * pre/post processing
		 * return an object
		 * parameter processingJoinpoit
		 * @throws Throwable 
		 */
		
		// using the around Advice to calculate during processing the target
		
		@Around("execution(* com.obeid.aopdemo.service.ExpectationService.getTrafficExpection(..))")
		public Object aroundAdviceGetTrafficService(ProceedingJoinPoint pjp) throws Throwable {
			
			// get the method be advised on
			String method = pjp.getSignature().toLongString();
			myLogger.info("\n>>>>>>>> @Around  on: "+ method);
			
			// pre_prodess
			Long start = System.currentTimeMillis();
			
			/**
			 * exception handling
			 * the main app will never know about the exception
			 */
			
			// target execute
			Object result = null;
			
			try {
				
				result = pjp.proceed();
				
			} catch (Throwable e) {
				
				// log the exception
				myLogger.warning(e.getMessage()); 
				
				// send custom message to the app
				//result =" NO Warries! We comming to help you :)";
				
				// otherwise you can re_throw_exc
				throw e;
				
			}
			
			
			//post_process
			Long end = System.currentTimeMillis();
			
			myLogger.info("Duration: "+ (end - start) +" Millis");
			
			myLogger.info("<<<<<<<	<< @Around (finally) end\n  ");
			return result;
			
		}

}
