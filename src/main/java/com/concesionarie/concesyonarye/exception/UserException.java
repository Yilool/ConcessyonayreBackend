package com.concesionarie.concesyonarye.exception;

@SuppressWarnings("serial")
public class UserException extends Exception{
	private final ExceptionsCode code;

	public UserException(ExceptionsCode cod) {
		super();
		this.code = cod;
	}

	public ExceptionsCode getCode() {
		return code;
	}
}
