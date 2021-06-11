package com.concesionarie.concesyonarye.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concesionarie.concesyonarye.exception.BrandException;
import com.concesionarie.concesyonarye.exception.CategoryException;
import com.concesionarie.concesyonarye.exception.ExceptionsCode;
import com.concesionarie.concesyonarye.exception.ModelException;
import com.concesionarie.concesyonarye.model.converter.ModelDtoConverter;
import com.concesionarie.concesyonarye.model.dto.ModelDto;
import com.concesionarie.concesyonarye.model.entity.Model;
import com.concesionarie.concesyonarye.model.repository.ModelRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ModelService.
 */
@Service("ModelService")
public class ModelService {
	
	/** The model repository. */
	@Autowired
	private ModelRepository modelRepository;
	
	/** The model dto converter. */
	@Autowired
	private ModelDtoConverter modelDtoConverter;
	
	/**
	 * Register new model.
	 *
	 * @param modelDto the model dto
	 * @return the model dto
	 * @throws ModelException the model exception
	 * @throws CategoryException the category exception
	 * @throws BrandException the brand exception
	 */
	public ModelDto registerNewModel(ModelDto modelDto) throws ModelException, CategoryException, BrandException {
		Model model = null;
		
		if (modelRepository.findModelByModelName(modelDto.getModelName().toUpperCase()) != null) {
			throw new ModelException(ExceptionsCode.MODEL_EXISTS);
		} else {
			model = modelDtoConverter.fromModelDTOToModel(modelDto);
		}
		
		return modelDtoConverter.fromModelToModelDto(modelRepository.save(model));
	}
	
	/**
	 * Delete model.
	 *
	 * @param code the code
	 * @return the model dto
	 * @throws ModelException the model exception
	 */
	public ModelDto deleteModel(String code) throws ModelException {
		Model model = modelRepository.findModelById(Integer.parseInt(code.substring(4)));
		
		if (model == null) {
			throw new ModelException(ExceptionsCode.MODEL_NOT_EXISTS);
		}
		
		model.setFinishDate(LocalDate.now());
		
		return modelDtoConverter.fromModelToModelDto(modelRepository.save(model));
	}
	
	/**
	 * Gets the all models.
	 *
	 * @return the all models
	 * @throws ModelException the model exception
	 */
	public List<ModelDto> getAllModels() throws ModelException {
		List<Model> models = modelRepository.findAll();
		
		if (models.size() == 0) {
			throw new ModelException(ExceptionsCode.NOT_MODELS);
		}
		
		List<ModelDto> modelDtos = new ArrayList<>();
		
		models.stream().forEach(model -> {
			ModelDto modelDto = modelDtoConverter.fromModelToModelDto(model);
			modelDtos.add(modelDto);
		});
		
		return modelDtos;
	}
}
