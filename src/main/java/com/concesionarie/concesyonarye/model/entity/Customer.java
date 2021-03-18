package com.concesionarie.concesyonarye.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String fullname;
	
	@Column(unique = true)
	private String bankaccount;
	
	private String address;
	
	@Column(unique = true)
	private String tlf;
	
	@Column(unique = true)
	private String dni;
	
	@OneToOne(mappedBy = "customer")
	private User user;
	
	public Customer() {}
	
	public Customer(String name, String surname, String bank, String address, String phone, String dni, User user) {
		this.fullname = name + " " + surname;
		this.bankaccount = bank;
		this.address = address;
		this.tlf = phone;
		this.dni = dni;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getBankaccount() {
		return bankaccount;
	}

	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
