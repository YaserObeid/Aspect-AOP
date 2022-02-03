package com.obeid.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.obeid.aopdemo.dao.AccountDAO;

public class AfterThrowingApp {
	
	private static Logger myLogger = 
			Logger.getLogger(AfterThrowingApp.class.getName());
	
	

	public static void main(String[] args) {
		
		// load the context using config_class (no_xml)
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// create beans from AddaccountDAO
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// simulate an exception
		
		List<Account> accounts = null;
		try {
			boolean someThingWrong = true;
			
			accounts = accountDAO.findAccounts(someThingWrong);
			
			
		} catch (Exception e) {
			myLogger.info("Exception: " + e);
		}
		myLogger.info("\nStart App: -----------------------");
		myLogger.info(accounts.toString());
		myLogger.info("End App  : -----------------------\n");
		
		
		
		
		
		
		context.close();
		
		

	}

}
