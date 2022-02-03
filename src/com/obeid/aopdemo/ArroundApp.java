package com.obeid.aopdemo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.obeid.aopdemo.service.ExpectationService;

public class ArroundApp {

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
