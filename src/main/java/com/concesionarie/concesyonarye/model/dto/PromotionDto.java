package com.concesionarie.concesyonarye.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class PromotionDto.
 */
@JsonInclude(Include.NON_NULL)
public class PromotionDto {
	
	/** The cod. */
	private String cod;
	
	/** The promoname. */
	private String promoname;
	
	/** The discount percent. */
	private int discountPercent;
	
	/** The start date. */
	private LocalDate startDate;
	
	/** The finish date. */
	private LocalDate finishDate;

	/**
	 * Gets the cod.
	 *
	 * @return the cod
	 */
	public String getCod() {
		return cod;
	}

	/**
	 * Sets the cod.
	 *
	 * @param cod the new cod
	 */
	public void setCod(String cod) {
		this.cod = cod;
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
}
