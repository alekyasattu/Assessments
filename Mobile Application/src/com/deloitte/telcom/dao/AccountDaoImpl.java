package com.deloitte.telcom.dao;

import java.util.HashMap;
import java.util.Map;

import com.deloitte.telcom.entities.Account;
import com.deloitte.telcom.exceptions.AccountNotFoundException;
import com.deloitte.telcom.exceptions.CustomerAlreadyExists;
import com.deloitte.telcom.exceptions.IncorrectMobileNoException;
import com.deloitte.telcom.exceptions.MobileNoDoesNotExistException;

public class AccountDaoImpl implements IAccountDao {
	
	private Map<String,Account> store= new HashMap<>();
	
	@Override
	public Map<String,Account> getStore(){
		return store;
	}
	
	@Override
	public Account createAccount(String mobileNo,String name,String accountType,double balance) {
		if(store.containsValue(mobileNo)) {
			throw new CustomerAlreadyExists("customer with mobile no already exists");
		}
		Account a = new Account(mobileNo, name, accountType, balance);
		store.put(mobileNo, a);
		return a;
	}

	@Override
	public Account accountBalanceEnquiry(String mobileNo) {
		if(store.containsKey(mobileNo)) {
			Account a = store.get(mobileNo);
			return a;
		}
		else {
			throw new MobileNoDoesNotExistException("Mobile No does not exist");
		}
	}

	@Override
	public Account rechargeAccount(String mobileNo, double amount) {
		
		if(store.containsKey(mobileNo)) {
			Account a = store.get(mobileNo);
			a.setBalance(a.getBalance()+amount);
			return a;
		}
		else {
			throw new MobileNoDoesNotExistException("Mobile No does not exist");
		}
			
	}
	
	@Override
	public Account findAccountByMobileNo(String mobileNo) {
		Account a = store.get(mobileNo);
			if(a==null) {
				throw new AccountNotFoundException("customer with account not found");
			}
			return a;
		}


}
