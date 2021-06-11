package com.concesionarie.concesyonarye.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// TODO: Auto-generated Javadoc
/**
 * The Class Rating.
 */
@Entity
public class Rating {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** The rate. */
	private int rate;
	
	/** The comment. */
	private String comment;
	
	/** The customer. */
	@ManyToOne
	@JoinColumn(name = "CustomerId")
	private Customer customer;
	
	/** The vehicle. */
	@ManyToOne
	@JoinColumn(name = "VehicleId")
	private Vehicle vehicle;
	
	/**
	 * Instantiates a new rating.
	 */
	public Rating() { }
	
	/**
	 * Instantiates a new rating.
	 *
	 * @param vehicle the vehicle
	 * @param customer the customer
	 */
	public Rating(Vehicle vehicle, Customer customer) {
		this.vehicle = vehicle;
		this.customer = customer;
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
	 * Gets the rate.
	 *
	 * @return the rate
	 */
	public int getRate() {
		return rate;
	}

	/**
	 * Sets the rate.
	 *
	 * @param rate the new rate
	 */
	public void setRate(int rate) {
		this.rate = rate;
	}

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment the new comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
}
