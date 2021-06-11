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
 * The Class Purchase.
 */
@Entity
public class Purchase {
	
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
	
	/** The purchase date. */
	private LocalDate purchaseDate;
	
	/** The final payment date. */
	private LocalDate finalPaymentDate;
	
	/**
	 * Instantiates a new purchase.
	 */
	public Purchase() {
		this.finalPrice = 0.0;
		this.purchaseDate = LocalDate.now();
		this.finalPaymentDate = null;
	}
	
	/**
	 * Instantiates a new purchase.
	 *
	 * @param customer the customer
	 * @param vehicle the vehicle
	 * @param promotion the promotion
	 */
	public Purchase(Customer customer, Vehicle vehicle, Promotion promotion) {
		this.customer = customer;
		this.vehicle = vehicle;
		this.promotion = promotion;
		this.purchaseDate = LocalDate.now();
		this.finalPaymentDate = null;
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
	 * Gets the purchase date.
	 *
	 * @return the purchase date
	 */
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * Sets the purchase date.
	 *
	 * @param purchaseDate the new purchase date
	 */
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	/**
	 * Gets the final payment date.
	 *
	 * @return the final payment date
	 */
	public LocalDate getFinalPaymentDate() {
		return finalPaymentDate;
	}

	/**
	 * Sets the final payment date.
	 *
	 * @param finalPaymentDate the new final payment date
	 */
	public void setFinalPaymentDate(LocalDate finalPaymentDate) {
		this.finalPaymentDate = finalPaymentDate;
	}
}
