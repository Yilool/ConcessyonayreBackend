package com.concesionarie.concesyonarye.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class ModelException.
 */
@SuppressWarnings("serial")
public class ModelException extends Exception{
	
	/** The code. */
	private final ExceptionsCode code;

	/**
	 * Instantiates a new model exception.
	 *
	 * @param cod the cod
	 */
	public ModelException(ExceptionsCode cod) {
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