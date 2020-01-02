package com.deloitte.telcom.service;

import com.deloitte.telcom.entities.Account;

public interface IAccountService {
	
Account accountBalanceEnquiry(String mobileNo);
	
	Account rechargeAccount(String mobileNo,double amount);
	
	//void createAccount(Account a);
	
	Account createAccount(String mobileNo,String name,String accountType,double balance); 


	Account findAccountByMobileNo(String mobileNo);
}
