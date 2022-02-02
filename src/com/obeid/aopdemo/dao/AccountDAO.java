package com.obeid.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.obeid.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account, boolean vip) {
		
		System.out.println(getClass()+ ": Adding an acount");
	}
	
public boolean anotherWork() {
		
		System.out.println(getClass()+ ": another work");
		
		return false;
	}

}
