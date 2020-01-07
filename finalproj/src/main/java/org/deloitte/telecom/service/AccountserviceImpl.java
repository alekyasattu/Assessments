package org.deloitte.telecom.service;

import org.deloitte.telecom.dao.*;
import org.deloitte.telecom.exceptions.*;
import org.springframework.stereotype.Service;
import org.deloitte.telecom.entities.*;

@Service
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
		
		
			return null;
		}

	
	 @Override
	    public boolean credentialsCorrect(String mobileNo, String password) {
	        boolean correct = dao.credentialsCorrect(mobileNo, password);
	        return correct;
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
