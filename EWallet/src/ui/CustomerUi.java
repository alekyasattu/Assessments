package ui;

import java.util.Collection;
import java.util.Set;

import dao.CustomerDaoImpl;
import entities.Customer;
import exceptions.CustomerNotFoundException;
import exceptions.IncorrectMobileNoException;
import service.CustomerServiceImpl;
import service.ICustomerService;

public class CustomerUi {

	private ICustomerService service = new CustomerServiceImpl(new CustomerDaoImpl());

	public static void main(String[] args) {
		
		CustomerUi ui = new CustomerUi();
		ui.runUi();

	}
	
	void runUi() {
		try {
		Customer c1 = new Customer("8500778474", "alekya", 3000.0);
		Customer c2 = new Customer("9494949885", "joe",1000.0);
		Customer c3 = new Customer("9494342713","sam",500.0);
		service.transferMoney(c1, c3, 1000);
		service.addCustomer(c1);
		service.addCustomer(c2);
		service.addCustomer(c3);
		Customer fetched1 = service.findEmployeeByMobileNo(c1.getMobileNo());
		Customer fetched2 = service.findEmployeeByMobileNo(c2.getMobileNo());
		
		//Customer fetched3 = service.findEmployeeByMobileNo("");

		
		System.out.println(fetched1.getName());
		System.out.println(fetched2.getName());
		//System.out.println(fetched3.getName());
		
		 System.out.println("********printing all customers of wallet****");
		 Set<Customer> customers = service.allCustomers();
		 
		 print(customers);
		 
		}
		catch(IncorrectMobileNoException e) {
			System.out.println("wrong mobile no");
		}
		catch(CustomerNotFoundException c) {
			System.out.println("customer not found");
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("something went wrong");
			
		}
	}
		 
		void print(Collection<Customer>customers){
	        for (Customer e:customers){
	            System.out.println(e.getName() + " "+e.getBalance());
	        }
		
		
	}

}
