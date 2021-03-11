package com.wipro.customExcep;

public class InvalidAmountException extends Exception {

	private static final long serialVersionUID = 1L;

	String message;

	public InvalidAmountException(String errMsg) {
		this.message = errMsg;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
