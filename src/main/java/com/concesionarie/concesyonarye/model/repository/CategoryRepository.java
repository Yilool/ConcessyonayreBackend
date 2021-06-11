package com.concesionarie.concesyonarye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concesionarie.concesyonarye.model.entity.Category;

// TODO: Auto-generated Javadoc
/**
 * The Interface CategoryRepository.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	/**
	 * Find category by category name.
	 *
	 * @param categoryName the category name
	 * @return the category
	 */
	public Category findCategoryByCategoryName(String categoryName);
	
	/**
	 * Find category by id.
	 *
	 * @param id the id
	 * @return the category
	 */
	public Category findCategoryById(Integer id);
}
