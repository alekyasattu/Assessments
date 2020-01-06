package com.deloitte.ecommerce.service;

import java.util.Set;

import com.deloitte.ecommerce.entities.*;

public interface ICustomerService {
	 Customer getCustomerByMobileNo(String mobileNo);

	 boolean credentialsCorrect(String mobileNo, String password);
}
