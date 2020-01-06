package dao;

import java.util.Set;

import entities.Customer;

public interface ICustomerWalletDao {

	void addCustomer(Customer c);
	
	void transferMoney(Customer c1,Customer c2,double amount);
	
	Customer findEmployeeByMobileNo(String mobileNo);
	
	Set<Customer> allCustomers();
}
