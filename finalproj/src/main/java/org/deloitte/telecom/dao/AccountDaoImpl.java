package org.deloitte.telecom.dao;

import java.util.HashMap;
import java.util.Map;

import org.deloitte.telecom.entities.*;
import org.deloitte.telecom.exceptions.*;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements IAccountDao {
	
	private Map<String,Account> store= new HashMap<>();
	
	public AccountDaoImpl() {
		Account a1 = new Account("8500778474", "alekya", "1234", "prepaid", 100.0);
		store.put(a1.getMobileNo(),a1);
	
	}
	
	
	
	@Override
	public Map<String,Account> getStore(){
		return store;
	}
	
	@Override
	public Account createAccount(String mobileNo,String name,String accountType,double balance) {
		return null;
	}

	
	@Override
    public boolean credentialsCorrect(String mobileNo, String password) {
        Account acc = store.get(mobileNo);
        if (acc == null) {
            return false;
        }
        return acc.getPassword().equals(password);
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
