package com.obeid.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.obeid.aopdemo.dao.AccountDAO;
import com.obeid.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// load the context using config_class (no_xml)
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// create beans from AddaccountDAO
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call business methods
		Account account = new Account();
		accountDAO.addAccount(account, true);
		accountDAO.anotherWork();
		
		
		// get beans from NembershipDAO
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call business methods
		membershipDAO.addANewMember(20);
		membershipDAO.doSomeTask();
		// close the context
		
		context.close();
		
		

	}

}
