package com.deloitte.telcom.ui;

import java.util.Collection;
import java.util.Scanner;

import com.deloitte.telcom.dao.AccountDaoImpl;
import com.deloitte.telcom.entities.Account;
import com.deloitte.telcom.service.AccountserviceImpl;
import com.deloitte.telcom.service.IAccountService;

public class AccountUi {
	
	IAccountService service = new AccountserviceImpl(new AccountDaoImpl());
	String mobileNo,name,accountType;
	double balance;
	
	
	Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		AccountUi ui = new AccountUi();
		ui.execute();
	
	}
	
	
	
	void execute() {
		
		String ch ;
		
	while(true) {
		System.out.println("Welcome to Mobile application Customer Care");
		System.out.println("---------------------------------------------");
		System.out.printf("Menu:\n 1.Account Balance enquiry\n2.Recharge account\n3.Create Account\n4.Exit");
		System.out.println("\nplease enter the no to avail its service");
		
		int option = in.nextInt();
		
		if(option == 1) {
			accountBalanceEnquiry();
		}else if(option == 2) {
			reachargeAccount();
		}else if(option == 3) {
			create();
		}else if(option == 4) {
			System.out.println("do u want to exit?press y to confirm" );
			ch = in.next();
			if(ch.equals("y"))
				break;
		}else {
			System.out.println("wrong option");
		}
		}
	}
		
	
	
	void create() {
		System.out.println("Please enter the details");
		System.out.println("mobile no:");
		mobileNo = in.next();
		System.out.println("name:");
		name = in.next();
		System.out.println("account type(prepaid and postpaid):");
		accountType = in.next();
		System.out.println("balance");
		balance= in.nextDouble();
		
		//Account a = new Account(mobileNo, name, accountType, balance);
		
		Account a = service.createAccount(mobileNo, name, accountType, balance);
		
		System.out.println("Account created!");
		
		print(a);
	}
	
	void reachargeAccount() {
		double amount;
		System.out.println("Please enter the mobil no:");
		mobileNo = in.next();
		System.out.println("please enter the amount to recharge:");
		amount= in.nextDouble();
		Account a = service.rechargeAccount(mobileNo, amount);
		System.out.println("account recharged with amount="+amount);
		System.out.println("New balance is :"+a.getBalance());
		System.out.println("-----------------DETAILS ARE----------------------------");
		print(a);
		
	}
	
	void accountBalanceEnquiry() {
		System.out.println("Please enter the mobil no:");
		mobileNo = in.next();
		Account a = service.accountBalanceEnquiry(mobileNo);
		System.out.println("Balance Details are :"+a.getBalance());
		
	}
	
	
	
	void print(Account a) {
		System.out.println("Mobile No:"+a.getMobileNo()+"\nName:"+a.getBalance()+"\nAccount Type:"+a.getAccountType()+"\nBalance:"+a.getBalance());
	}

}
