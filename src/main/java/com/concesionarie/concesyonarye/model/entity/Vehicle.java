package com.concesionarie.concesyonarye.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.concesionarie.concesyonarye.model.enumerate.Fuel;

// TODO: Auto-generated Javadoc
/**
 * The Class Vehicle.
 */
@Entity
public class Vehicle {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** The enrollment. */
	@Column(unique = true)
	private String enrollment;
	
	/** The base price. */
	private double basePrice;
	
	/** The userseats. */
	private int userseats;
	
	/** The fuel. */
	private Fuel fuel;
	
	/** The imagen. */
	@Lob
	private byte[] imagen;
	
	/** The model. */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = false)
	private Model model;
	
	/** The rating. */
	@OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
	private List<Rating> rating;
	
	/**
	 * Instantiates a new vehicle.
	 */
	public Vehicle() { 
		this.rating = new ArrayList<>();
	}
	
	/**
	 * Instantiates a new vehicle.
	 *
	 * @param price the price
	 * @param seats the seats
	 * @param fuel the fuel
	 * @param model the model
	 */
	public Vehicle(double price, int seats, Fuel fuel, Model model) { 
		this.rating = new ArrayList<>();
		this.basePrice = price;
		this.userseats = seats;
		this.fuel = fuel;
		this.enrollment = null;
		this.model = model;
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
		this.enrollment = enrollment.toUpperCase();
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
	public Fuel getFuel() {
		return fuel;
	}

	/**
	 * Sets the fuel.
	 *
	 * @param fuel the new fuel
	 */
	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	public void setModel(Model model) {
		this.model = model;
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
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public List<Rating> getRating() {
		return rating;
	}

	/**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}
}
