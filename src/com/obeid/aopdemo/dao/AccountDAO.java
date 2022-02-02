package com.obeid.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.obeid.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	// method return accounts
	public List<Account> findAccounts(boolean somethingWrong) {
		
		if(somethingWrong)
			throw new RuntimeException("Stop!.. something is wrong!");
		List<Account> accounts = new ArrayList<>();
		
		Account account1 = new Account("Obeid", "Platinum");
		Account account2 = new Account("Homsi", "Golden");
		Account account3 = new Account("Morad", "Silver");
		Account account4 = new Account("Tomas", "Golden");
		
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		accounts.add(account4);
		
		return accounts;
		
	}
	
	// getter - setter
	
	public String getName() {
		System.out.println(getClass() +": getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() +": setName(String name)");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() +": getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() +": setServiceCode(String serviceCode)");
		this.serviceCode = serviceCode;
	}

	
	// other methods
	
	
	public void addAccount(Account account, boolean vip) {
		
		System.out.println(getClass()+ ": Adding an acount");
	}
	
	
	public boolean anotherWork() {
		
		System.out.println(getClass()+ ": another work");
		
		return false;
	}

}
