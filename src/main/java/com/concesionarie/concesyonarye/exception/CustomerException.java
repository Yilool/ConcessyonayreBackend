package com.concesionarie.concesyonarye.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerException.
 */
@SuppressWarnings("serial")
public class CustomerException extends Exception{
	
	/** The code. */
	private final ExceptionsCode code;

	/**
	 * Instantiates a new customer exception.
	 *
	 * @param cod the cod
	 */
	public CustomerException(ExceptionsCode cod) {
		super();
		this.code = cod;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public ExceptionsCode getCode() {
		return code;
	}
}