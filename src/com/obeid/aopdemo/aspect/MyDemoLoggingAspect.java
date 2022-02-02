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
		 *  you can combine multiple pointcut declaration:
		 *  as same as is if statement using &&, || !
		 *  
		 */
		
		// match all methods in package_dao
		
		@Pointcut("execution(* com.obeid.aopdemo.dao.*.*(..))")
		private void forDaoPackage() {}
		
		// match all SETTER methods in package_dao
		
		@Pointcut("execution(* com.obeid.aopdemo.dao.*.set*(..))")
		private void forSetterDaoPackage() {}
		
		// match all GETTER methods in package_dao
		
		@Pointcut("execution(* com.obeid.aopdemo.dao.*.get*(..))")
		private void forGetterDaoPackage() {}
        
		
		/**
		 * Combination many pointcut_declaration
		 * all methods package_dao except getter & setter
		 * 
		 */
		
		@Pointcut("forDaoPackage() && !(forGetterDaoPackage() || forSetterDaoPackage())")
		private void forDaoPackageExeptGetterSetter() {}
		
		
		// will be applied on all methods exclude getter / setter
		
		@Before("forDaoPackageExeptGetterSetter()")
		public void beforeAddAcount() {
			
			System.out.println("\n>>>>>>@Before Aaading account");
		}
		
		
		
	}
