package service;

import java.util.Set;

import entities.Customer;

public interface ICustomerService {
	 
void addCustomer(Customer c);
	
void transferMoney(Customer c1,Customer c2,double amount);

	Customer findEmployeeByMobileNo(String mobileNo);
	
	Set<Customer> allCustomers();

}
