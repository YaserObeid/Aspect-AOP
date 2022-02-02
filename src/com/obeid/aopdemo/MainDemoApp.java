package com.obeid.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.obeid.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// load the context using config_class (no_xml)
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// create beans
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call business method
		
		accountDAO.addAccount();
		
		// close the context
		
		context.close();
		
		

	}

}
