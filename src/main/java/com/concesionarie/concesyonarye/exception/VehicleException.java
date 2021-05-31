package com.concesionarie.concesyonarye.exception;

@SuppressWarnings("serial")
public class VehicleException extends Exception{
	private final ExceptionsCode code;

	public VehicleException(ExceptionsCode cod) {
		super();
		this.code = cod;
	}

	public ExceptionsCode getCode() {
		return code;
	}
}
