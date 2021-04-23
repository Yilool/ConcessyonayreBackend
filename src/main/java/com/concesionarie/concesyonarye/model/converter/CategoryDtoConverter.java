package com.concesionarie.concesyonarye.model.converter;

import org.springframework.stereotype.Component;

import com.concesionarie.concesyonarye.model.dto.CategoryDto;
import com.concesionarie.concesyonarye.model.entity.Category;

@Component
public class CategoryDtoConverter {
	private static final String code = "CAT0";
	
	public Category fromCategoryDTOToCategory(CategoryDto categoryDto) {
		Category category = new Category(categoryDto.getCategoryName());
		
		return category;
	}
	
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
