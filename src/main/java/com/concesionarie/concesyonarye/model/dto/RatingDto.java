package com.concesionarie.concesyonarye.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class RatingDto.
 */
@JsonInclude(Include.NON_NULL)
public class RatingDto {
	
	/** The rate. */
	private int rate;
	
	/** The comment. */
	private String comment;
	
	/** The customer. */
	private int customer;
	
	/** The vehicle. */
	private String vehicle;

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

	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public int getCustomer() {
		return customer;
	}

	/**
	 * Sets the customer.
	 *
	 * @param customer the new customer
	 */
	public void setCustomer(int customer) {
		this.customer = customer;
	}

	/**
	 * Gets the vehicle.
	 *
	 * @return the vehicle
	 */
	public String getVehicle() {
		return vehicle;
	}

	/**
	 * Sets the vehicle.
	 *
	 * @param vehicle the new vehicle
	 */
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
}
