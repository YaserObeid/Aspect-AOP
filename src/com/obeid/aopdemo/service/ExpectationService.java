package com.obeid.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class ExpectationService {
	
	
	// simulate a delay
	
	public String getTrafficExpection() {
		
		// take a while 5 seconds
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		return "Expect a heavy traffic todaty";
		
	}

	public String getTrafficExpection(boolean wrong) {
		
		if(wrong)
			throw new RuntimeException("there is an accident on the highway!!!");
		
		return getTrafficExpection();
	}

}
