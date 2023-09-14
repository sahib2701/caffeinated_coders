package com.demo.exceptions;

public class InvoiceNotFoundException extends Exception {
	public InvoiceNotFoundException(String msg) {
		super(msg);
	}
	
	public InvoiceNotFoundException(String msg, Throwable cause) {
		super(msg,cause);
	}
}
