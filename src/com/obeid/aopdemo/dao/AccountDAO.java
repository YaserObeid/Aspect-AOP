package com.obeid.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.obeid.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
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
