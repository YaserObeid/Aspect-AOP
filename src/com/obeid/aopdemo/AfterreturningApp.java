package com.obeid.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.obeid.aopdemo.dao.AccountDAO;

public class AfterReturningApp {
	
	private static Logger myLogger = 
			Logger.getLogger(AfterReturningApp.class.getName());

	public static void main(String[] args) {
		
		// load the context using config_class (no_xml)
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// create beans from AddaccountDAO
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accounts = accountDAO.findAccounts(false);
		/**
		 * here after_returning is called
		 */
		myLogger.info("\nStart App: -----------------------");
		myLogger.info(accounts.toString());
		myLogger.info("End App  : -----------------------\n");
		
		
		
		context.close();
		
		

	}

}
