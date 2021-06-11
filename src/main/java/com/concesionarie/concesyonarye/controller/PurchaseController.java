package com.concesionarie.concesyonarye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.concesionarie.concesyonarye.exception.CustomerException;
import com.concesionarie.concesyonarye.exception.PromotionException;
import com.concesionarie.concesyonarye.exception.PurchaseException;
import com.concesionarie.concesyonarye.exception.VehicleException;
import com.concesionarie.concesyonarye.model.dto.PurchaseDto;
import com.concesionarie.concesyonarye.service.PurchaseService;

// TODO: Auto-generated Javadoc
/**
 * The Class PurchaseController.
 */
@CrossOrigin
@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
	/** The purchase service. */
	@Autowired
	private PurchaseService purchaseService;
	
	/**
	 * Gets the customers.
	 *
	 * @return the customers
	 */
	@GetMapping
	public ResponseEntity<?> getCustomers() {
		try {
			return ResponseEntity.ok(purchaseService.getCustomers());
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * New purchase.
	 *
	 * @param purchaseDto the purchase dto
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<?> newPurchase(@RequestBody PurchaseDto purchaseDto) {
		try {
			return ResponseEntity.ok(purchaseService.makePurchase(purchaseDto));
		} catch (VehicleException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch (PurchaseException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch (CustomerException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch(PromotionException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
}
