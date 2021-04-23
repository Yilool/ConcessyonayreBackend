package com.concesionarie.concesyonarye.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int rate;
	
	private String comment;
	
	@ManyToOne
	@JoinColumn(name = "CustomerId")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "VehicleId")
	private Vehicle vehicle;
	
	public Rating() { }
	
	public Rating(Vehicle vehicle, Customer customer) {
		this.vehicle = vehicle;
		this.customer = customer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
