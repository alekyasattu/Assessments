package com.deloitte.telcom.exceptions;

public class CustomerAlreadyExists extends RuntimeException {

	public CustomerAlreadyExists(String msg) {
		super(msg);
	}
}
