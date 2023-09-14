package com.demo.exceptions;

public class CustomerNotFoundException extends Exception{
	public CustomerNotFoundException(String msg) {
		super(msg);
	}
	
	public CustomerNotFoundException(String msg, Throwable cause) {
		super(msg,cause);
	}
}
