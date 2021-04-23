package com.concesionarie.concesyonarye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.concesionarie.concesyonarye.exception.BrandException;
import com.concesionarie.concesyonarye.service.BrandService;

@CrossOrigin
@RestController
@RequestMapping("/brand")
public class BrandController {
	@Autowired
	private BrandService brandService;
	
	@PostMapping
	public ResponseEntity<?> newBrand(@PathVariable String Brand) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(brandService.registerNewBrand(Brand));
		} catch (BrandException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteBrand(@PathVariable String code) {
		try {
			return ResponseEntity.ok(brandService.deleteBrand(code));
		} catch (BrandException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> getBrands() {
		try {
			return ResponseEntity.ok(brandService.getAllBrands());
		} catch (BrandException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
}
