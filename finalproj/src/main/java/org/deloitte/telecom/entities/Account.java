package org.deloitte.telecom.entities;

public class Account {

	
	private String mobileNo;
	private String name;
	private String password;
	private String accountType;
	private double balance;
	
	public Account() {
		this("","","","",0.0);
	}
	
	public Account(String mobileNo, String name, String password, String accountType, double balance) {
		
		this.mobileNo = mobileNo;
		this.name = name;
		this.password = password;
		this.accountType = accountType;
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public int hashcode() {
		return mobileNo.hashCode();
		}
	
	public String toString() {
		 String display = mobileNo +" "+name+" "+" "+accountType+" "+balance;
		 return display;
	}
	
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		if(obj==null || !(obj instanceof Account)) {
			return false;
		}
		Account c = (Account)obj;
		return c.mobileNo.equals(this.mobileNo);
		
	}
	
	
}
