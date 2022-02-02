package com.obeid.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.obeid.aopdemo.dao.AccountDAO;

public class AfterThrowingApp {

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
			System.out.println("Exception: " + e);
		}
		System.out.println("\nStart App: -----------------------");
		System.out.println(accounts);
		System.out.println("End App  : -----------------------\n");
		
		
		
		
		
		
		context.close();
		
		

	}

}
