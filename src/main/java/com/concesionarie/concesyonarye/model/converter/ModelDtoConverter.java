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

// TODO: Auto-generated Javadoc
/**
 * The Class ModelDtoConverter.
 */
@Component
public class ModelDtoConverter {
	
	/** The Constant code. */
	private static final String code = "MOD0";
	
	/** The category repository. */
	@Autowired
	private CategoryRepository categoryRepository;
	
	/** The brand repository. */
	@Autowired
	private BrandRepository brandRepository;

	/**
	 * From model DTO to model.
	 *
	 * @param modelDto the model dto
	 * @return the model
	 * @throws CategoryException the category exception
	 * @throws BrandException the brand exception
	 */
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
	
	/**
	 * From model to model dto.
	 *
	 * @param model the model
	 * @return the model dto
	 */
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
