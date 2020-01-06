package com.deloitte.ecommerce.dao;

import java.util.Set;

import com.deloitte.ecommerce.entities.*;

public interface ICustomerWalletDao {

	 Customer getCustomerByMobileNo(String mobileNo);

	 boolean credentialsCorrect(String mobileNo, String password);
}
