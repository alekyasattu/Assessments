package com.deloitte.ecommerce.service;

import java.util.Set;

import com.deloitte.ecommerce.dao.ICustomerWalletDao;
import com.deloitte.ecommerce.entities.Customer;
import com.deloitte.ecommerce.exceptions.IncorrectMobileNoException;


public class CustomerServiceImpl implements ICustomerService {

	private ICustomerWalletDao dao;
	
	
	public CustomerServiceImpl(ICustomerWalletDao dao) {
		this.dao = dao;
	}

	  @Override
	    public Customer getCustomerByMobileNo(String mobileNo) {
		  if(mobileNo==null||mobileNo.length()!=10) {
			  throw new IncorrectMobileNoException("wrong mobile no");
		  }
	
		  Customer c = dao.getCustomerByMobileNo(mobileNo);
	        return c;
	  }
	       
	   

	    @Override
	    public boolean credentialsCorrect(String mobileNo, String password) {
	        boolean correct = dao.credentialsCorrect(mobileNo, password);
	        return correct;
	    }
}