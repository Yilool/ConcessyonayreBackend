package com.concesionarie.concesyonarye.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class BrandException.
 */
@SuppressWarnings("serial")
public class BrandException extends Exception{
	
	/** The code. */
	private final ExceptionsCode code;

	/**
	 * Instantiates a new brand exception.
	 *
	 * @param cod the cod
	 */
	public BrandException(ExceptionsCode cod) {
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
