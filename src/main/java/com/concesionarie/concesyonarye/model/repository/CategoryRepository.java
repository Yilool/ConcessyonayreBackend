package com.concesionarie.concesyonarye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concesionarie.concesyonarye.model.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	public Category findCategoryByCategoryName(String categoryName);
	public Category findCategoryById(Integer id);
}
