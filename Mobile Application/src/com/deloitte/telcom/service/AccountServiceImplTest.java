package com.deloitte.telcom.service;

import org.junit.Test;

import com.deloitte.telcom.dao.AccountDaoImpl;
import com.deloitte.telcom.entities.Account;
import com.deloitte.telcom.exceptions.CustomerAlreadyExists;
import com.deloitte.telcom.exceptions.IncorrectMobileNoException;

import java.util.Map;

import org.junit.Assert;

public class AccountServiceImplTest {
	
	
	@Test
	public void testCreateAccount_1() {
		AccountserviceImpl service = new AccountserviceImpl(new AccountDaoImpl());
		String mobileNo = "1234567890";
		double balance=1000;
		String name="alekya";
		String accountType = "prepaid";
		Account account = service.createAccount(mobileNo, name, accountType, balance);
		Assert.assertNotNull(account);
		double resultBalance = account.getBalance();
		Assert.assertEquals(balance, resultBalance,0);
		Assert.assertEquals(name, account.getName());
		Map<String,Account> store = service.getDao().getStore();
		Account expected = store.get(mobileNo);
		Assert.assertEquals(expected, account);
		
		
	}
	
	
	@Test(expected = IncorrectMobileNoException.class )
	public void testCreateAccount_2() {
		AccountserviceImpl service = new AccountserviceImpl(new AccountDaoImpl());
		String mobileNo = "12345";
		double balance=1000;
		String name="alekya";
		String accountType = "prepaid";
		Account account = service.createAccount(mobileNo, name, accountType, balance);
}
	@Test
	public void testFindByMobileNo_1() {
		AccountserviceImpl service = new AccountserviceImpl(new AccountDaoImpl());
		String mobileNo = "1234567890";
		double balance=1000;
		String name="alekya";
		String accountType = "prepaid";
		Account account = service.createAccount(mobileNo, name, accountType, balance);
		Map<String,Account> store = service.getDao().getStore();
		store.put(mobileNo, account);
		Assert.assertNotNull(account);
		Account fetched = service.findAccountByMobileNo(mobileNo);
		Assert.assertEquals(account, fetched);
		
	}
	
	
}