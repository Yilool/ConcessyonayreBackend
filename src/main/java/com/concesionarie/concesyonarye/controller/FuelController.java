package com.concesionarie.concesyonarye.controller;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concesionarie.concesyonarye.model.enumerate.Fuel;

// TODO: Auto-generated Javadoc
/**
 * The Class FuelController.
 */
@CrossOrigin
@RestController
@RequestMapping("/fuel")
public class FuelController {
	
	/**
	 * Gets the fuels.
	 *
	 * @return the fuels
	 */
	@GetMapping
	public ResponseEntity<?> getFuels() {
		ResponseEntity<?> response;
		
		response = ResponseEntity.ok(Arrays.stream(Fuel.values()).map(r -> new String[] {r.name()}).collect(Collectors.toList()).toArray());
		
		return response;
	}
}
