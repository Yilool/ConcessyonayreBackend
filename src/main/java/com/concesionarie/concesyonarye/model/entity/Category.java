package com.concesionarie.concesyonarye.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class Category.
 */
@Entity
public class Category {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** The category name. */
	@Column(unique = true)
	private String categoryName;
	
	/** The start date. */
	private LocalDate startDate;
	
	/** The finish date. */
	private LocalDate finishDate;
	
	/**
	 * Instantiates a new category.
	 */
	public Category() {
		this.startDate = LocalDate.now();
		this.finishDate = null;
	}
	
	/**
	 * Instantiates a new category.
	 *
	 * @param name the name
	 */
	public Category(String name) {
		this.categoryName = name.toUpperCase();
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
	 * Gets the category name.
	 *
	 * @return the category name
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Sets the category name.
	 *
	 * @param categoryName the new category name
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
}
