package com.concesionarie.concesyonarye.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class PurchaseException.
 */
@SuppressWarnings("serial")
public class PurchaseException extends Exception{
	
	/** The code. */
	private final ExceptionsCode code;

	/**
	 * Instantiates a new purchase exception.
	 *
	 * @param cod the cod
	 */
	public PurchaseException(ExceptionsCode cod) {
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
