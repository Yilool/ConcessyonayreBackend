package com.concesionarie.concesyonarye.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class VehicleDto.
 */
@JsonInclude(Include.NON_NULL)
public class VehicleDto {
	
	/** The cod. */
	private String cod;
	
	/** The enrollment. */
	private String enrollment;
	
	/** The base price. */
	private double basePrice;
	
	/** The userseats. */
	private int userseats;
	
	/** The fuel. */
	private String fuel;
	
	/** The photo. */
	private String photo;
	
	/** The imagen. */
	private byte[] imagen;
	
	/** The model. */
	private String model;
	
	/** The rates. */
	private List<RatingDto> rates;
	
	/** The rate. */
	private double rate;

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
	 * Gets the base price.
	 *
	 * @return the base price
	 */
	public double getBasePrice() {
		return basePrice;
	}

	/**
	 * Sets the base price.
	 *
	 * @param basePrice the new base price
	 */
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * Gets the userseats.
	 *
	 * @return the userseats
	 */
	public int getUserseats() {
		return userseats;
	}

	/**
	 * Sets the userseats.
	 *
	 * @param userseats the new userseats
	 */
	public void setUserseats(int userseats) {
		this.userseats = userseats;
	}

	/**
	 * Gets the fuel.
	 *
	 * @return the fuel
	 */
	public String getFuel() {
		return fuel;
	}

	/**
	 * Sets the fuel.
	 *
	 * @param fuel the new fuel
	 */
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	/**
	 * Gets the photo.
	 *
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * Sets the photo.
	 *
	 * @param photo the new photo
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * Gets the imagen.
	 *
	 * @return the imagen
	 */
	public byte[] getImagen() {
		return imagen;
	}

	/**
	 * Sets the imagen.
	 *
	 * @param imagen the new imagen
	 */
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Gets the rates.
	 *
	 * @return the rates
	 */
	public List<RatingDto> getRates() {
		return rates;
	}

	/**
	 * Sets the rates.
	 *
	 * @param rates the new rates
	 */
	public void setRates(List<RatingDto> rates) {
		this.rates = rates;
	}

	/**
	 * Gets the rate.
	 *
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * Sets the rate.
	 *
	 * @param rate the new rate
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}
}
