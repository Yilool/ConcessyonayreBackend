package com.concesionarie.concesyonarye.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerDto.
 */
@JsonInclude(Include.NON_NULL)
public class CustomerDto {
	
	/** The cod. */
	private String cod;
	
	/** The fullname. */
	private String fullname;
	
	/** The dni. */
	private String dni;

	/**
	 * Gets the cod.
	 *
	 * @return the cod
	 */
	public String getCod() {
		return cod;
	}

	/**
	 * Sets the cod.
	 *
	 * @param cod the new cod
	 */
	public void setCod(String cod) {
		this.cod = cod;
	}

	/**
	 * Gets the fullname.
	 *
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * Sets the fullname.
	 *
	 * @param fullname the new fullname
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * Gets the dni.
	 *
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Sets the dni.
	 *
	 * @param dni the new dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
}
