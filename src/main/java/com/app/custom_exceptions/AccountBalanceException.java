package com.app.custom_exceptions;

@SuppressWarnings("serial")
public class AccountBalanceException extends RuntimeException {

	public AccountBalanceException(String me) {
		super(me);
	}
}
