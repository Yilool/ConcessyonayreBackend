package com.concesionarie.concesyonarye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concesionarie.concesyonarye.model.entity.Promotion;

// TODO: Auto-generated Javadoc
/**
 * The Interface PromotionRepository.
 */
@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer>{
	
	/**
	 * Find promotion by id.
	 *
	 * @param id the id
	 * @return the promotion
	 */
	public Promotion findPromotionById(Integer id);
	
	/**
	 * Find promotion by promoname.
	 *
	 * @param promoname the promoname
	 * @return the promotion
	 */
	public Promotion findPromotionByPromoname(String promoname);
	
	/**
	 * Find promotion by discount percent.
	 *
	 * @param discountPercent the discount percent
	 * @return the promotion
	 */
	public Promotion findPromotionByDiscountPercent(int discountPercent);
}
