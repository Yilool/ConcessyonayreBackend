package com.concesionarie.concesyonarye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.concesionarie.concesyonarye.exception.CustomerException;
import com.concesionarie.concesyonarye.exception.PurchaseException;
import com.concesionarie.concesyonarye.exception.VehicleException;
import com.concesionarie.concesyonarye.model.dto.RatingDto;
import com.concesionarie.concesyonarye.service.RatingService;

// TODO: Auto-generated Javadoc
/**
 * The Class RatingController.
 */
@CrossOrigin
@RestController
@RequestMapping("/rating")
public class RatingController {
	
	/** The rating service. */
	@Autowired
	private RatingService ratingService;
	
	/**
	 * Gets the customer vehicle.
	 *
	 * @param cus the cus
	 * @return the customer vehicle
	 */
	@GetMapping(path = "/{cus}")
	public ResponseEntity<?> getCustomerVehicle(@PathVariable int cus) {
		try {
			return ResponseEntity.ok(ratingService.getCustomerVehicles(cus));
		} catch (PurchaseException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch (CustomerException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Post rating.
	 *
	 * @param ratingDto the rating dto
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<?> postRating(@RequestBody RatingDto ratingDto) {
		try {
			return ResponseEntity.ok(ratingService.rateVehicle(ratingDto));
		} catch (VehicleException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch (CustomerException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
}
