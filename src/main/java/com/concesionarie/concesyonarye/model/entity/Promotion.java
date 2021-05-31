package com.concesionarie.concesyonarye.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Promotion {
	private static final int RENT_DISCOUNT = 2;
	private static final int BUY_DISCOUNT = 6;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String promoname;
	
	private int discountPercent;
	
	private LocalDate startDate;
	
	private LocalDate finishDate;
	
	public Promotion() {
		this.discountPercent = 0;
		this.startDate = LocalDate.now();
		this.finishDate = null;
	}
	
	public Promotion(String name, int discount) {
		this.promoname = name.toUpperCase();
		this.discountPercent = discount;
		this.startDate = LocalDate.now();
		this.finishDate = null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPromoname() {
		return promoname;
	}

	public void setPromoname(String promoname) {
		this.promoname = promoname;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}

	public static int getRentDiscount() {
		return RENT_DISCOUNT;
	}

	public static int getBuyDiscount() {
		return BUY_DISCOUNT;
	}
}
