package com.obeid.aopdemo;


import java.util.logging.Logger;

//import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.obeid.aopdemo.service.ExpectationService;

public class AroundApp {
	/**
	 * Change the OutPut Stream
	 * 
	 * define the logger of this class
	 * it is used as Spring output
	 * Sys.out: use the system out put
	 */
	//private static Logger myLogger = Logger.getLogger(ArroundApp.class.getName());
	// then you must replace myLogger.info with myLogger.info
	
	private static Logger myLogger = 
			Logger.getLogger(AroundApp.class.getName());
	

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
