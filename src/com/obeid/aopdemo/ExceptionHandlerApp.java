package com.obeid.aopdemo;


import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.obeid.aopdemo.service.ExpectationService;

public class ExceptionHandlerApp {
	// change to output to App logger
	private static Logger myLogger = 
			Logger.getLogger(ExceptionHandlerApp.class.getName());
	// replace myLogger.info -> myLogger.info
	

	public static void main(String[] args) {
		
		// load the context using config_class (no_xml)
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// create beans from Service
		
		ExpectationService expectationService = 
			context.getBean("expectationService", ExpectationService.class);
		
		myLogger.info("Calling Service ..");
		
		myLogger.info(expectationService.getTrafficExpection());
		
		myLogger.info("Ending Service :)");
		
		
		
		context.close();
		
		

	}

}
