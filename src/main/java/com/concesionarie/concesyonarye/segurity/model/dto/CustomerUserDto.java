package com.concesionarie.concesyonarye.segurity.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerUserDto.
 */
@JsonInclude(Include.NON_NULL)
public class CustomerUserDto {

	/** The username. */
	private String username;

	/** The password. */
	private String password;

	/** The roles. */
	private String roles;
	
	/** The name. */
	private String name;
	
	/** The surname. */
	private String surname;

	/** The bankaccount. */
	private String bankaccount;
	
	/** The address. */
	private String address;

	/** The tlf. */
	private String tlf;

	/** The dni. */
	private String dni;

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	public String getRoles() {
		return roles;
	}

	/**
	 * Sets the roles.
	 *
	 * @param roles the new roles
	 */
	public void setRoles(String roles) {
		this.roles = roles;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the surname.
	 *
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets the surname.
	 *
	 * @param surname the new surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Gets the bankaccount.
	 *
	 * @return the bankaccount
	 */
	public String getBankaccount() {
		return bankaccount;
	}

	/**
	 * Sets the bankaccount.
	 *
	 * @param bankaccount the new bankaccount
	 */
	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the tlf.
	 *
	 * @return the tlf
	 */
	public String getTlf() {
		return tlf;
	}

	/**
	 * Sets the tlf.
	 *
	 * @param tlf the new tlf
	 */
	public void setTlf(String tlf) {
		this.tlf = tlf;
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
