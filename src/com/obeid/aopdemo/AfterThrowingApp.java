package com.obeid.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.obeid.aopdemo.dao.AccountDAO;
import com.obeid.aopdemo.dao.MembershipDAO;

public class AfterThrowingApp {

	public static void main(String[] args) {
		
		// load the context using config_class (no_xml)
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// create beans from AddaccountDAO
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// simulate an exception
		
		boolean someThingWrong = true;
		try {
			List<Account> accounts = accountDAO.findAccounts(someThingWrong);
			System.out.println("\nStart AfteThrowinggApp: -----------------------");
			System.out.println(accounts);
			System.out.println("End AfteThrowinggApp  : -----------------------\n");
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		
		
		
		
		
		
		context.close();
		
		

	}

}
