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

@CrossOrigin
@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	@Autowired
	private PurchaseService purchaseService;
	
	@GetMapping
	public ResponseEntity<?> getCustomers() {
		try {
			return ResponseEntity.ok(purchaseService.getCustomers());
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
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
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
}
