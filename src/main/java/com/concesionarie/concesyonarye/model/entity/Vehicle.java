package com.concesionarie.concesyonarye.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.concesionarie.concesyonarye.model.enumerate.Fuel;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String enrollment;
	
	private double basePrice;
	
	private int userseats;
	
	private Fuel fuel;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = false)
	private Model model;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "rating_id", referencedColumnName = "id", nullable = false)
	private Rating rating;
	
	public Vehicle() { }
	
	public Vehicle(String enrollment, double price, int seats, Fuel fuel) { 
		this.enrollment = enrollment;
		this.basePrice = price;
		this.userseats = seats;
		this.fuel = fuel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public int getUserseats() {
		return userseats;
	}

	public void setUserseats(int userseats) {
		this.userseats = userseats;
	}

	public Fuel getFuel() {
		return fuel;
	}

	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}
}