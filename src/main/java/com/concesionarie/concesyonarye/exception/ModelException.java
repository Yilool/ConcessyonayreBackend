package com.concesionarie.concesyonarye.exception;

@SuppressWarnings("serial")
public class ModelException extends Exception{
	private final ExceptionsCode code;

	public ModelException(ExceptionsCode cod) {
		super();
		this.code = cod;
	}

	public ExceptionsCode getCode() {
		return code;
	}
}