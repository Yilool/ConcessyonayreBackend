package com.concesionarie.concesyonarye.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class CategoryException.
 */
@SuppressWarnings("serial")
public class CategoryException extends Exception{
	
	/** The code. */
	private final ExceptionsCode code;

	/**
	 * Instantiates a new category exception.
	 *
	 * @param cod the cod
	 */
	public CategoryException(ExceptionsCode cod) {
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