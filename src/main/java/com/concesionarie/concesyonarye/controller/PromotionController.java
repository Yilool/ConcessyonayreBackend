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

import com.concesionarie.concesyonarye.exception.PromotionException;
import com.concesionarie.concesyonarye.model.dto.PromotionDto;
import com.concesionarie.concesyonarye.service.PromotionService;

// TODO: Auto-generated Javadoc
/**
 * The Class PromotionController.
 */
@CrossOrigin
@RestController
@RequestMapping("/promotion")
public class PromotionController {
	
	/** The promotion service. */
	@Autowired
	private PromotionService promotionService;
	
	/**
	 * New promotion.
	 *
	 * @param promotionDto the promotion dto
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<?> newPromotion(@RequestBody PromotionDto promotionDto) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(promotionService.registerNewPromotion(promotionDto));
		} catch (PromotionException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Delete promotion.
	 *
	 * @param code the code
	 * @return the response entity
	 */
	@DeleteMapping
	public ResponseEntity<?> deletePromotion(@PathVariable String code) {
		try {
			return ResponseEntity.ok(promotionService.deletePromotion(code));
		} catch (PromotionException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Gets the promotions.
	 *
	 * @return the promotions
	 */
	@GetMapping
	public ResponseEntity<?> getPromotions() {
		try {
			return ResponseEntity.ok(promotionService.getAllPromotions());
		} catch (PromotionException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
}
