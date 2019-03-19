package com.testingfly.file.io;

import com.opencsv.bean.CsvBindByName;

public class TestInput {
	
	@CsvBindByName(column="Environment")
	private String environment;
	
	@CsvBindByName(column="First Name")
	private String firstName;
	
	@CsvBindByName(column="Last Name")
	private String lastName;
	
	@CsvBindByName(column="Account Number")
	private String accountNum;
	
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	@Override
	public String toString() {
		return "TestInput [environment=" + environment + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", accountNum=" + accountNum + "]";
	}
	
}
