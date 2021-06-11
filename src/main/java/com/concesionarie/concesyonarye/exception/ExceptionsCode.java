package com.concesionarie.concesyonarye.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

// TODO: Auto-generated Javadoc
/**
 * The Enum ExceptionsCode.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ExceptionsCode {
	
	/** The user exists. */
	/* User code */
	USER_EXISTS("The user already exist in the aplication"),
	
	/** The user not exists. */
	USER_NOT_EXISTS("The user not exist in the aplication"),
	
	/** The not users. */
	NOT_USERS("There aren't users in the application"),
	
	/** The not brands. */
	/* Brand code */
	NOT_BRANDS("There aren't brands in the application"),
	
	/** The brand exists. */
	BRAND_EXISTS("The brand already exist in the aplication"),
	
	/** The brand not exists. */
	BRAND_NOT_EXISTS("The brand not exist in the aplication"),
	
	/** The not categories. */
	/* Category code */
	NOT_CATEGORIES("There aren't categories in the application"),
	
	/** The category exists. */
	CATEGORY_EXISTS("The category already exist in the aplication"),
	
	/** The category not exists. */
	CATEGORY_NOT_EXISTS("The category not exist in the aplication"),
	
	/** The not models. */
	/* Model code */
	NOT_MODELS("There aren't models in the application"),
	
	/** The model exists. */
	MODEL_EXISTS("The model already exist in the aplication"),
	
	/** The model not exists. */
	MODEL_NOT_EXISTS("The model not exist in the aplication"),
	
	/** The not vehicles. */
	/* Vehicle code */
	NOT_VEHICLES("There aren't vehicles in the application"),
	
	/** The vehicle exists. */
	VEHICLE_EXISTS("The vehicle already exist in the aplication"),
	
	/** The vehicle not exists. */
	VEHICLE_NOT_EXISTS("The vehicle not exist in the aplication"),
	
	/** The not promotions. */
	/* Promotion code */
	NOT_PROMOTIONS("There aren't promotions in the application"),
	
	/** The promotion exists. */
	PROMOTION_EXISTS("The promotion already exist in the aplication"),
	
	/** The promotion not exists. */
	PROMOTION_NOT_EXISTS("The promotion not exist in the aplication"),
	
	/** The customer not exists. */
	/* Customer code */
	CUSTOMER_NOT_EXISTS("The customer not exist in the aplication"),
	
	/** The not purchases. */
	/* Purchase code */
	NOT_PURCHASES("There aren't purchases in the application"),
	
	/** The vehicle selled. */
	VEHICLE_SELLED("This vehicle was selled"),
	
	/** The enrollment used. */
	ENROLLMENT_USED("There are a vehicle with that enrollment");
	
	/** The message. */
	private final String message;
	
	/**
	 * Instantiates a new exceptions code.
	 *
	 * @param msg the msg
	 */
	private ExceptionsCode(String msg) {
		this.message = msg;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
}
