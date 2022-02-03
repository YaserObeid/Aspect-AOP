package com.obeid.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.obeid.aopdemo.dao.AccountDAO;

public class AfterFinallyApp {
	
	private static Logger myLogger = 
			Logger.getLogger(AfterFinallyApp.class.getName());

	public static void main(String[] args) {
		
		// load the context using config_class (no_xml)
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// create beans from AddaccountDAO
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// simulate an exception
		
		List<Account> accounts = null;
		boolean someThingWrong = false;
		try {
			
			accounts = accountDAO.findAccounts(someThingWrong);
			
			myLogger.info("\nStart App: -----------------------");
			myLogger.info(accounts.toString());
			myLogger.info("End App  : -----------------------\n");
			
			
		} catch (Exception e) {
			myLogger.info("Exception: " + e);
		}
		
		
		
		
		
		
		
		context.close();
		
		

	}

}
