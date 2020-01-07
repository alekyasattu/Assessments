package org.deloitte.telecom.exceptions;

public class MobileNoDoesNotExistException extends RuntimeException {

	public MobileNoDoesNotExistException(String msg) {
		super(msg);
	}
}
