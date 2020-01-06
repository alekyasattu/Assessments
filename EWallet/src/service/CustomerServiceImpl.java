package service;

import java.util.Set;

import dao.ICustomerWalletDao;
import entities.Customer;
import exceptions.IncorrectMobileNoException;

public class CustomerServiceImpl implements ICustomerService {

	private ICustomerWalletDao dao;
	
	
	public CustomerServiceImpl(ICustomerWalletDao dao) {
		this.dao = dao;
	}

	@Override
	public void addCustomer(Customer c) {

		dao.addCustomer(c);

	}
	
	 @Override
	public void transferMoney(Customer c1, Customer c2, double amount) {
		dao.transferMoney(c1, c2, amount);
		
	}

	@Override
	public Customer findEmployeeByMobileNo(String mobileNo) {
		
		if(mobileNo == null || mobileNo.length()!=10) {
			throw new IncorrectMobileNoException(" mobile no is incorrect");
		}
		Customer c =dao.findEmployeeByMobileNo(mobileNo);
		return c;
	}

	@Override
	public Set<Customer> allCustomers() {
		Set<Customer> customers = dao.allCustomers();
		return customers;
	}

}
