	package com.obeid.aopdemo.aspect;
	
	import org.aspectj.lang.annotation.Aspect;
	import org.aspectj.lang.annotation.Pointcut;
	
	@Aspect
	public class AopExpression {
		
		
		// match all methods in package_dao
		
		@Pointcut("execution(* com.obeid.aopdemo.dao.*.*(..))")
		public void forDaoPackage() {}
		
		// match all SETTER methods in package_dao
		
		@Pointcut("execution(* com.obeid.aopdemo.dao.*.set*(..))")
		public void forSetterDaoPackage() {}
		
		// match all GETTER methods in package_dao
		
		@Pointcut("execution(* com.obeid.aopdemo.dao.*.get*(..))")
		public void forGetterDaoPackage() {}
        
		
		/**
		 * Combination many pointcut_declaration
		 * all methods package_dao except getter & setter
		 * 
		 */
		
		@Pointcut("forDaoPackage() && !(forGetterDaoPackage() || forSetterDaoPackage())")
		public void forDaoPackageExeptGetterSetter() {}
		
		
		
		
		
		
	}
