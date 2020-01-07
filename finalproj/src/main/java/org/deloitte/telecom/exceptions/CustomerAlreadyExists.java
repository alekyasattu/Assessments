package org.deloitte.telecom.exceptions;

public class CustomerAlreadyExists extends RuntimeException {

	public CustomerAlreadyExists(String msg) {
		super(msg);
	}
}
