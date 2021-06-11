package com.concesionarie.concesyonarye.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class BrandDto.
 */
@JsonInclude(Include.NON_NULL)
public class BrandDto {
	
	/** The cod. */
	private String cod;
	
	/** The brand name. */
	private String brandName;
	
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
	 * Gets the brand name.
	 *
	 * @return the brand name
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * Sets the brand name.
	 *
	 * @param brandName the new brand name
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
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
