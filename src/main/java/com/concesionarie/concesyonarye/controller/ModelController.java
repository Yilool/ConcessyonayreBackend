package com.concesionarie.concesyonarye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.concesionarie.concesyonarye.exception.CategoryException;
import com.concesionarie.concesyonarye.exception.ModelException;
import com.concesionarie.concesyonarye.model.dto.ModelDto;
import com.concesionarie.concesyonarye.service.ModelService;

// TODO: Auto-generated Javadoc
/**
 * The Class ModelController.
 */
@CrossOrigin
@RestController
@RequestMapping("/model")
public class ModelController {
	
	/** The Model service. */
	@Autowired
	private ModelService ModelService;
	
	/**
	 * New model.
	 *
	 * @param modelDto the model dto
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<?> newModel(@RequestBody ModelDto modelDto) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(ModelService.registerNewModel(modelDto));
		} catch (ModelException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch (CategoryException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Delete model.
	 *
	 * @param code the code
	 * @return the response entity
	 */
	@DeleteMapping
	public ResponseEntity<?> deleteModel(@PathVariable String code) {
		try {
			return ResponseEntity.ok(ModelService.deleteModel(code));
		} catch (ModelException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Gets the models.
	 *
	 * @return the models
	 */
	@GetMapping
	public ResponseEntity<?> getModels() {
		try {
			return ResponseEntity.ok(ModelService.getAllModels());
		} catch (ModelException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
}
