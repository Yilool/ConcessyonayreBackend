package com.concesionarie.concesyonarye.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concesionarie.concesyonarye.exception.CategoryException;
import com.concesionarie.concesyonarye.exception.ExceptionsCode;
import com.concesionarie.concesyonarye.model.converter.CategoryDtoConverter;
import com.concesionarie.concesyonarye.model.dto.CategoryDto;
import com.concesionarie.concesyonarye.model.entity.Category;
import com.concesionarie.concesyonarye.model.repository.CategoryRepository;

@Service("CategoryService")
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryDtoConverter categoryDtoConverter;
	
	public CategoryDto registerNewCategory(String name) throws CategoryException {
		Category category;
		
		if (categoryRepository.findCategoryByCategoryName(name.toUpperCase()) != null) {
			throw new CategoryException(ExceptionsCode.CATEGORY_EXISTS);
		} else {
			category = new Category(name);
		}
		
		return categoryDtoConverter.fromCategoryToCategoryDto(categoryRepository.save(category));
	}
	
	public CategoryDto deleteCategory(String code) throws CategoryException {
		Category category = categoryRepository.findCategoryById(Integer.parseInt(code.substring(0)));
		
		if (category == null) {
			throw new CategoryException(ExceptionsCode.CATEGORY_NOT_EXISTS);
		}
		
		category.setFinishDate(LocalDate.now());
		
		return categoryDtoConverter.fromCategoryToCategoryDto(categoryRepository.save(category));
	}
	
	public List<CategoryDto> getAllCategories() throws CategoryException {
		List<Category> categories = categoryRepository.findAll();
		
		if (categories.size() == 0) {
			throw new CategoryException(ExceptionsCode.NOT_CATEGORIES);
		}
		
		List<CategoryDto> categoryDtos = new ArrayList<>();
		
		categories.stream().forEach(category -> {
			CategoryDto categoryDto = categoryDtoConverter.fromCategoryToCategoryDto(category);
			categoryDtos.add(categoryDto);
		});
		
		return categoryDtos;
	}
}
