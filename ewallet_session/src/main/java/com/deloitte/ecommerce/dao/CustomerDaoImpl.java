package com.deloitte.ecommerce.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.deloitte.ecommerce.entities.*;
import com.deloitte.ecommerce.exceptions.CustomerNotFoundException;

import com.deloitte.ecommerce.entities.*;

public class CustomerDaoImpl implements ICustomerWalletDao {

	private Map<String,Customer> store = new HashMap<>();
	
	
	
	public CustomerDaoImpl() {
		Customer c1 = new Customer("8500778474", "1234", "alekya", 1000.0);
		store.put(c1.getMobileNo(),c1);
		Customer c2 = new Customer("9494949885", "4567", "joe", 2000.0);
		store.put(c2.getMobileNo(), c2);
	}
	
	@Override
	public Customer getCustomerByMobileNo(String mobileNo) {
		Customer c = store.get(mobileNo);
		if(c == null) {
			throw new CustomerNotFoundException("customer not found for mobile no"+mobileNo);
		}
		 return c;
	}
	
	@Override
	public boolean credentialsCorrect(String mobilNo, String password) {
        Customer c = store.get(mobilNo);
        if (c == null) {
            return false;
        }
        return c.getPassword().equals(password);
    }

	
}
