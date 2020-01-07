package org.deloitte.telecom.dao;

import java.util.Map;

import org.deloitte.telecom.entities.*;

public interface IAccountDao {
	
	Account accountBalanceEnquiry(String mobileNo);
	
	Account rechargeAccount(String mobileNo,double amount);
	
	//void createAccount(Account a);
	
	Account createAccount(String mobileNo,String name,String accountType,double balance); 
	
	Map<String,Account> getStore();
	
	boolean credentialsCorrect(String mobileNo, String password);
	
	

	Account findAccountByMobileNo(String mobileNo);

	
}
