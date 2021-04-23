package com.concesionarie.concesyonarye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concesionarie.concesyonarye.model.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{
	public Brand findBrandByBrandName(String brandName);
	public Brand findBrandById(Integer id);
}
