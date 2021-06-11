package com.concesionarie.concesyonarye.model.converter;

import org.springframework.stereotype.Component;

import com.concesionarie.concesyonarye.model.dto.CategoryDto;
import com.concesionarie.concesyonarye.model.entity.Category;

// TODO: Auto-generated Javadoc
/**
 * The Class CategoryDtoConverter.
 */
@Component
public class CategoryDtoConverter {
	
	/** The Constant code. */
	private static final String code = "CAT0";
	
	/**
	 * From category DTO to category.
	 *
	 * @param categoryDto the category dto
	 * @return the category
	 */
	public Category fromCategoryDTOToCategory(CategoryDto categoryDto) {
		Category category = new Category(categoryDto.getCategoryName());
		
		return category;
	}
	
	/**
	 * From category to category dto.
	 *
	 * @param category the category
	 * @return the category dto
	 */
	public CategoryDto fromCategoryToCategoryDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		
		categoryDto.setCod(code + category.getId());
		categoryDto.setCategoryName(category.getCategoryName());
		categoryDto.setStartDate(category.getStartDate());
		
		if (category.getFinishDate() != null) {
			categoryDto.setFinishDate(category.getFinishDate());
		}
		
		return categoryDto;
	}
}
