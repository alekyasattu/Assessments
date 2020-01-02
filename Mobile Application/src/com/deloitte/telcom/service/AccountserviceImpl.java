package com.deloitte.telcom.service;

import com.deloitte.telcom.dao.IAccountDao;
import com.deloitte.telcom.entities.Account;
import com.deloitte.telcom.exceptions.IncorrectAccountTypeException;
import com.deloitte.telcom.exceptions.IncorrectBalanceException;
import com.deloitte.telcom.exceptions.IncorrectMobileNoException;
import com.deloitte.telcom.exceptions.IncorrectValuesException;

public class AccountserviceImpl implements IAccountService {
	
	private IAccountDao dao;
	
	

	public IAccountDao getDao() {
		return dao;
	}

	public AccountserviceImpl(IAccountDao dao) {
		this.dao = dao;
	}

	@Override
	public Account createAccount(String mobileNo,String name,String accountType,double balance) {
		
		if(mobileNo==null||mobileNo.length()!=10) {
			throw new IncorrectMobileNoException("mobile no isnt correct");
		}else if(balance<0.0) {
			throw new IncorrectBalanceException("balance less than 0 not accepted");
		}
		else {
			Account a = dao.createAccount(mobileNo, name, accountType, balance);
			return a;
		}

	}

	@Override
	public Account accountBalanceEnquiry(String mobileNo) {
		if(mobileNo == null|| mobileNo.length()!=10) {
			throw new IncorrectMobileNoException("wrong mobile no");
		}
		
		Account a = dao.accountBalanceEnquiry(mobileNo);
		return a;
	}

	@Override
	public Account rechargeAccount(String mobileNo, double amount) {
		if(mobileNo == null|| mobileNo.length()!=10) {
			throw new IncorrectMobileNoException("wrong mobile no");
		}
		
		if(amount<0.0) {
			System.out.println("enter proper amonut");
		}
		
		Account a = dao.rechargeAccount(mobileNo, amount);
		return a;
	
	}
	
	@Override

	public Account findAccountByMobileNo(String mobileNo) {
		if(mobileNo==null||mobileNo.length()!=10) {
			throw new IncorrectMobileNoException("mobile no is incorrect");
		}
		Account a = dao.findAccountByMobileNo(mobileNo);
		return a;
	}


}
