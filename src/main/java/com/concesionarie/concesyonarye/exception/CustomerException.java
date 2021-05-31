package com.concesionarie.concesyonarye.exception;

@SuppressWarnings("serial")
public class CustomerException extends Exception{
	private final ExceptionsCode code;

	public CustomerException(ExceptionsCode cod) {
		super();
		this.code = cod;
	}

	public ExceptionsCode getCode() {
		return code;
	}
}