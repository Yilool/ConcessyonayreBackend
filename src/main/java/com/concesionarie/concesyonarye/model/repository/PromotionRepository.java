package com.concesionarie.concesyonarye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concesionarie.concesyonarye.model.entity.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer>{
	public Promotion findPromotionById(Integer id);
	
	public Promotion findPromotionByPromoname(String promoname);
	
	public Promotion findPromotionByDiscountPercent(int discountPercent);
}
