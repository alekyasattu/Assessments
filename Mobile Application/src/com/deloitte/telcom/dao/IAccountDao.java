package com.deloitte.telcom.dao;

import java.util.Map;

import com.deloitte.telcom.entities.Account;

public interface IAccountDao {
	
	Account accountBalanceEnquiry(String mobileNo);
	
	Account rechargeAccount(String mobileNo,double amount);
	
	//void createAccount(Account a);
	
	Account createAccount(String mobileNo,String name,String accountType,double balance); 
	
	Map<String,Account> getStore();
	
	

	Account findAccountByMobileNo(String mobileNo);

	
}
