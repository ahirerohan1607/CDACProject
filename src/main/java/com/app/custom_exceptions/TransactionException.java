package com.app.custom_exceptions;

@SuppressWarnings("serial")
public class TransactionException extends RuntimeException {

	public TransactionException(String me) {
		super(me);
	}
}
