package com.concesionarie.concesyonarye.exception;

@SuppressWarnings("serial")
public class BrandException extends Exception{
	private final ExceptionsCode code;

	public BrandException(ExceptionsCode cod) {
		super();
		this.code = cod;
	}

	public ExceptionsCode getCode() {
		return code;
	}
}
