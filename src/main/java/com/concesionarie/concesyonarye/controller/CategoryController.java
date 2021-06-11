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
import com.concesionarie.concesyonarye.service.CategoryService;

// TODO: Auto-generated Javadoc
/**
 * The Class CategoryController.
 */
@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {
	
	/** The category service. */
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * New category.
	 *
	 * @param category the category
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<?> newCategory(@RequestBody String category) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.registerNewCategory(category));
		} catch (CategoryException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Delete category.
	 *
	 * @param code the code
	 * @return the response entity
	 */
	@DeleteMapping
	public ResponseEntity<?> deleteCategory(@PathVariable String code) {
		try {
			return ResponseEntity.ok(categoryService.deleteCategory(code));
		} catch (CategoryException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Gets the categories.
	 *
	 * @return the categories
	 */
	@GetMapping
	public ResponseEntity<?> getCategories() {
		try {
			return ResponseEntity.ok(categoryService.getAllCategories());
		} catch (CategoryException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
}
