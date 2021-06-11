package com.concesionarie.concesyonarye.model.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// TODO: Auto-generated Javadoc
/**
 * The Class Model.
 */
@Entity
public class Model {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** The model name. */
	@Column(unique = true)
	private String modelName;
	
	/** The start date. */
	private LocalDate startDate;
	
	/** The finish date. */
	private LocalDate finishDate;
	
	/** The brand. */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable = false)
	private Brand brand;
	
	/** The category. */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
	private Category category;
	
	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.startDate = LocalDate.now();
		this.finishDate = null;
	}
	
	/**
	 * Instantiates a new model.
	 *
	 * @param name the name
	 * @param brand the brand
	 * @param category the category
	 */
	public Model(String name, Brand brand, Category category) {
		this.modelName = name.toUpperCase();
		this.startDate = LocalDate.now();
		this.finishDate = null;
		this.brand = brand;
		this.category = category;
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
	 * Gets the model name.
	 *
	 * @return the model name
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * Sets the model name.
	 *
	 * @param modelName the new model name
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
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
	 * Gets the brand.
	 *
	 * @return the brand
	 */
	public Brand getBrand() {
		return brand;
	}

	/**
	 * Sets the brand.
	 *
	 * @param brand the new brand
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
}
