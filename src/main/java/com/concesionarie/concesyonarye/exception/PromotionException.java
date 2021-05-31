package com.concesionarie.concesyonarye.exception;

@SuppressWarnings("serial")
public class PromotionException extends Exception{
	private final ExceptionsCode code;

	public PromotionException(ExceptionsCode cod) {
		super();
		this.code = cod;
	}

	public ExceptionsCode getCode() {
		return code;
	}
}
