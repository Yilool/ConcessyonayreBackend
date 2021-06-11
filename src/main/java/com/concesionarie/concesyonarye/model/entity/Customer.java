package com.concesionarie.concesyonarye.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.concesionarie.concesyonarye.segurity.model.entity.User;

// TODO: Auto-generated Javadoc
/**
 * The Class Customer.
 */
@Entity
public class Customer {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** The fullname. */
	@Column(unique = true)
	private String fullname;
	
	/** The bankaccount. */
	@Column(unique = true)
	private String bankaccount;
	
	/** The address. */
	private String address;
	
	/** The tlf. */
	@Column(unique = true)
	private String tlf;
	
	/** The dni. */
	@Column(unique = true)
	private String dni;
	
	/** The user. */
	@OneToOne(mappedBy = "customer")
	private User user;
	
	/**
	 * Instantiates a new customer.
	 */
	public Customer() {}
	
	/**
	 * Instantiates a new customer.
	 *
	 * @param name the name
	 * @param surname the surname
	 * @param bank the bank
	 * @param address the address
	 * @param phone the phone
	 * @param dni the dni
	 * @param user the user
	 */
	public Customer(String name, String surname, String bank, String address, String phone, String dni, User user) {
		this.fullname = name + " " + surname;
		this.bankaccount = bank;
		this.address = address;
		this.tlf = phone;
		this.dni = dni;
		this.user = user;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
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

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
