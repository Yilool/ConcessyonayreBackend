package com.concesionarie.concesyonarye.model.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

// TODO: Auto-generated Javadoc
/**
 * The Class Rental.
 */
@Entity
public class Rental {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** The customer. */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
	private Customer customer;
	
	/** The vehicle. */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "vehicle_id", referencedColumnName = "id", nullable = false)
	private Vehicle vehicle;

	/** The promotion. */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "promotion_id", referencedColumnName = "id", nullable = false)
	private Promotion promotion;
	
	/** The final price. */
	private double finalPrice;
	
	/** The rental date. */
	private LocalDate rentalDate;
	
	/** The return date. */
	private LocalDate returnDate;
	
	/**
	 * Instantiates a new rental.
	 */
	public Rental() {
		this.rentalDate = LocalDate.now();
		this.returnDate = LocalDate.now().plusDays(1);
	}
	
	/**
	 * Instantiates a new rental.
	 *
	 * @param customer the customer
	 * @param vehicle the vehicle
	 * @param promotion the promotion
	 * @param days the days
	 */
	public Rental(Customer customer, Vehicle vehicle, Promotion promotion, long days) {
		this.customer = customer;
		this.vehicle = vehicle;
		this.promotion = promotion;
		this.rentalDate = LocalDate.now();
		this.returnDate = LocalDate.now().plusDays(days);
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
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Sets the customer.
	 *
	 * @param customer the new customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Gets the vehicle.
	 *
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * Sets the vehicle.
	 *
	 * @param vehicle the new vehicle
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * Gets the promotion.
	 *
	 * @return the promotion
	 */
	public Promotion getPromotion() {
		return promotion;
	}

	/**
	 * Sets the promotion.
	 *
	 * @param promotion the new promotion
	 */
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	/**
	 * Gets the final price.
	 *
	 * @return the final price
	 */
	public double getFinalPrice() {
		return finalPrice;
	}

	/**
	 * Sets the final price.
	 *
	 * @param finalPrice the new final price
	 */
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	/**
	 * Gets the rental date.
	 *
	 * @return the rental date
	 */
	public LocalDate getRentalDate() {
		return rentalDate;
	}

	/**
	 * Sets the rental date.
	 *
	 * @param rentalDate the new rental date
	 */
	public void setRentalDate(LocalDate rentalDate) {
		this.rentalDate = rentalDate;
	}

	/**
	 * Gets the return date.
	 *
	 * @return the return date
	 */
	public LocalDate getReturnDate() {
		return returnDate;
	}

	/**
	 * Sets the return date.
	 *
	 * @param returnDate the new return date
	 */
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
}
