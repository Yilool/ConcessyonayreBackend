package com.concesionarie.concesyonarye.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class PurchaseDto.
 */
@JsonInclude(Include.NON_NULL)
public class PurchaseDto {
	
	/** The vehicle. */
	private String vehicle;
	
	/** The customer. */
	private String customer;
	
	/** The enrollment. */
	private String enrollment;
	
	/** The promotion. */
	private String promotion;
	
	/** The financing. */
	private Boolean financing;

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

	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * Sets the customer.
	 *
	 * @param customer the new customer
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * Gets the enrollment.
	 *
	 * @return the enrollment
	 */
	public String getEnrollment() {
		return enrollment;
	}

	/**
	 * Sets the enrollment.
	 *
	 * @param enrollment the new enrollment
	 */
	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}

	/**
	 * Gets the financing.
	 *
	 * @return the financing
	 */
	public Boolean getFinancing() {
		return financing;
	}

	/**
	 * Sets the financing.
	 *
	 * @param financing the new financing
	 */
	public void setFinancing(Boolean financing) {
		this.financing = financing;
	}

	/**
	 * Gets the promotion.
	 *
	 * @return the promotion
	 */
	public String getPromotion() {
		return promotion;
	}

	/**
	 * Sets the promotion.
	 *
	 * @param promotion the new promotion
	 */
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	
	
}
