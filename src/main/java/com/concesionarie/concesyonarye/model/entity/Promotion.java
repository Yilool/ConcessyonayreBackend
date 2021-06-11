package com.concesionarie.concesyonarye.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class Promotion.
 */
@Entity
public class Promotion {
	
	/** The Constant RENT_DISCOUNT. */
	private static final int RENT_DISCOUNT = 2;
	
	/** The Constant BUY_DISCOUNT. */
	private static final int BUY_DISCOUNT = 6;
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** The promoname. */
	@Column(unique = true)
	private String promoname;
	
	/** The discount percent. */
	private int discountPercent;
	
	/** The start date. */
	private LocalDate startDate;
	
	/** The finish date. */
	private LocalDate finishDate;
	
	/**
	 * Instantiates a new promotion.
	 */
	public Promotion() {
		this.discountPercent = 0;
		this.startDate = LocalDate.now();
		this.finishDate = null;
	}
	
	/**
	 * Instantiates a new promotion.
	 *
	 * @param name the name
	 * @param discount the discount
	 */
	public Promotion(String name, int discount) {
		this.promoname = name.toUpperCase();
		this.discountPercent = discount;
		this.startDate = LocalDate.now();
		this.finishDate = null;
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
	 * Gets the promoname.
	 *
	 * @return the promoname
	 */
	public String getPromoname() {
		return promoname;
	}

	/**
	 * Sets the promoname.
	 *
	 * @param promoname the new promoname
	 */
	public void setPromoname(String promoname) {
		this.promoname = promoname;
	}

	/**
	 * Gets the discount percent.
	 *
	 * @return the discount percent
	 */
	public int getDiscountPercent() {
		return discountPercent;
	}

	/**
	 * Sets the discount percent.
	 *
	 * @param discountPercent the new discount percent
	 */
	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the finish date.
	 *
	 * @return the finish date
	 */
	public LocalDate getFinishDate() {
		return finishDate;
	}

	/**
	 * Sets the finish date.
	 *
	 * @param finishDate the new finish date
	 */
	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}

	/**
	 * Gets the rent discount.
	 *
	 * @return the rent discount
	 */
	public static int getRentDiscount() {
		return RENT_DISCOUNT;
	}

	/**
	 * Gets the buy discount.
	 *
	 * @return the buy discount
	 */
	public static int getBuyDiscount() {
		return BUY_DISCOUNT;
	}
}
