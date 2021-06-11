package com.concesionarie.concesyonarye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concesionarie.concesyonarye.model.entity.Brand;

// TODO: Auto-generated Javadoc
/**
 * The Interface BrandRepository.
 */
@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{
	
	/**
	 * Find brand by brand name.
	 *
	 * @param brandName the brand name
	 * @return the brand
	 */
	public Brand findBrandByBrandName(String brandName);
	
	/**
	 * Find brand by id.
	 *
	 * @param id the id
	 * @return the brand
	 */
	public Brand findBrandById(Integer id);
}
