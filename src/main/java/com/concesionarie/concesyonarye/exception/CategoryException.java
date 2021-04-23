package com.concesionarie.concesyonarye.exception;

@SuppressWarnings("serial")
public class CategoryException extends Exception{
	private final ExceptionsCode code;

	public CategoryException(ExceptionsCode cod) {
		super();
		this.code = cod;
	}

	public ExceptionsCode getCode() {
		return code;
	}
}