package com.obeid.aopdemo;


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
	// then you must replace System.out.println with myLogger.info
	

	public static void main(String[] args) {
		
		// load the context using config_class (no_xml)
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// create beans from Service
		
		ExpectationService expectationService = 
			context.getBean("expectationService", ExpectationService.class);
		
		System.out.println("Calling Service ..");
		
		System.out.println(expectationService.getTrafficExpection());
		
		System.out.println("Ending Service :)");
		
		
		
		context.close();
		
		

	}

}
