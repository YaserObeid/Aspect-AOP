package com.obeid.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addANewMember(int a) {
			
			System.out.println( getClass()+ ": Adding an acount"+a);
			
	}
	
	
	public int doSomeTask() {
		
		System.out.println( getClass()+ ": doing Task");
		return 0;
		
}

}
