package com.brs.exception;

public class BRSException extends Exception {

	public BRSException(String message, Throwable cause) {
		super(message, cause);
	}

	public BRSException(String message) {
		super(message);
	}
}
