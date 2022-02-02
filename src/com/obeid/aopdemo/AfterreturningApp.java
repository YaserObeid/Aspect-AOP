package com.obeid.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.obeid.aopdemo.dao.AccountDAO;
import com.obeid.aopdemo.dao.MembershipDAO;

public class AfterreturningApp {

	public static void main(String[] args) {
		
		// load the context using config_class (no_xml)
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// create beans from AddaccountDAO
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accounts = accountDAO.findAccounts();
		/**
		 * here after_returning is called
		 */
		System.out.println("\nStart AfterreturningApp: -----------------------");
		System.out.println(accounts);
		System.out.println("End AfterreturningApp  : -----------------------\n");
		
		
		
		context.close();
		
		

	}

}
