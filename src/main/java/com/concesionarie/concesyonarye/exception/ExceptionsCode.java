package com.concesionarie.concesyonarye.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ExceptionsCode {
	/* User code */
	USER_EXISTS("The user already exist in the aplication"),
	USER_NOT_EXISTS("The user not exist in the aplication"),
	NOT_USERS("There aren't users in the application"),
	
	/* Brand code */
	NOT_BRANDS("There aren't brands in the application"),
	BRAND_EXISTS("The brand already exist in the aplication"),
	BRAND_NOT_EXISTS("The brand not exist in the aplication"),
	
	/* Category code */
	NOT_CATEGORIES("There aren't categories in the application"),
	CATEGORY_EXISTS("The category already exist in the aplication"),
	CATEGORY_NOT_EXISTS("The category not exist in the aplication"),
	
	/* Model code */
	NOT_MODELS("There aren't models in the application"),
	MODEL_EXISTS("The model already exist in the aplication"),
	MODEL_NOT_EXISTS("The model not exist in the aplication");
	
	private final String message;
	
	private ExceptionsCode(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}
}