package org.deloitte.telecom.service;

import org.deloitte.telecom.entities.*;

public interface IAccountService {
	
Account accountBalanceEnquiry(String mobileNo);
	
	Account rechargeAccount(String mobileNo,double amount);
	
	//void createAccount(Account a);
	
	Account createAccount(String mobileNo,String name,String accountType,double balance); 
	
	boolean credentialsCorrect(String mobileNo, String password);


	Account findAccountByMobileNo(String mobileNo);
}
