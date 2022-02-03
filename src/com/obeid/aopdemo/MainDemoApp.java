package com.obeid.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.obeid.aopdemo.dao.AccountDAO;
import com.obeid.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
	
	private static Logger myLogger = 
			Logger.getLogger(ExceptionHandlerApp.class.getName());

	public static void main(String[] args) {
		
		// load the context using config_class (no_xml)
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// create beans from AddaccountDAO
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call getter & setter
		accountDAO.setName("name");
		accountDAO.setServiceCode("code");
		
		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();
		
		// call business methods
		Account account = new Account();
		account.setName("Yaser Obeid");
		account.setLevel("Platinum");
		accountDAO.addAccount(account, true);
		accountDAO.anotherWork();
		
		
		// get beans from NembershipDAO
		MembershipDAO membershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
		// call business methods
		membershipDAO.addANewMember(20);
		membershipDAO.doSomeTask();
		// close the context
		
		context.close();
		
		

	}

}
