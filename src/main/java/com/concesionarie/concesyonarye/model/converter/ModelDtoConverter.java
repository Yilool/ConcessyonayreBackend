package com.concesionarie.concesyonarye.model.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concesionarie.concesyonarye.exception.BrandException;
import com.concesionarie.concesyonarye.exception.CategoryException;
import com.concesionarie.concesyonarye.exception.ExceptionsCode;
import com.concesionarie.concesyonarye.model.dto.ModelDto;
import com.concesionarie.concesyonarye.model.entity.Brand;
import com.concesionarie.concesyonarye.model.entity.Category;
import com.concesionarie.concesyonarye.model.entity.Model;
import com.concesionarie.concesyonarye.model.repository.BrandRepository;
import com.concesionarie.concesyonarye.model.repository.CategoryRepository;

@Component
public class ModelDtoConverter {
	private static final String code = "MOD0";
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BrandRepository brandRepository;

	public Model fromModelDTOToModel(ModelDto modelDto) throws CategoryException, BrandException {
		Model model;
		
		Category category = categoryRepository.findCategoryByCategoryName(modelDto.getCategory().toUpperCase());
		
		Brand brand = brandRepository.findBrandByBrandName(modelDto.getBrand().toUpperCase());
		
		if (brand == null) {
			throw new BrandException(ExceptionsCode.BRAND_NOT_EXISTS);
		}
		
		if (category == null) {
			throw new CategoryException(ExceptionsCode.CATEGORY_NOT_EXISTS);
		}
		
		model = new Model(modelDto.getModelName().toUpperCase(), brand, category);
		
		return model;
	}
	
	public ModelDto fromModelToModelDto(Model model) {
		ModelDto modelDto = new ModelDto();
		
		modelDto.setCod(code + model.getId());
		modelDto.setModelName(model.getModelName());
		modelDto.setBrand(model.getBrand().getBrandName());
		modelDto.setCategory(model.getCategory().getCategoryName());
		modelDto.setStartDate(model.getStartDate());
		
		if (model.getFinishDate() != null) {
			modelDto.setFinishDate(model.getFinishDate());
		}
		
		return modelDto;
	}
}
