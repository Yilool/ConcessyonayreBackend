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

import com.concesionarie.concesyonarye.exception.ModelException;
import com.concesionarie.concesyonarye.exception.VehicleException;
import com.concesionarie.concesyonarye.model.dto.VehicleDto;
import com.concesionarie.concesyonarye.service.VehicleService;

@CrossOrigin
@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping
	public ResponseEntity<?> newVehicle(@RequestBody VehicleDto vehicleDto) {
			try {
				return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.registerNewVehicle(vehicleDto));
			} catch (ModelException e) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
			} catch(Exception ex) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
	}
	
	@GetMapping(path = "/{cod}")
	public ResponseEntity<?> getVehicle(@PathVariable String cod) {
			try {
				return ResponseEntity.ok(vehicleService.getVehicle(cod));
			} catch (VehicleException e) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
			} catch(Exception ex) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
	}
	
	@GetMapping
	public ResponseEntity<?> getVehicles() {
			try {
				return ResponseEntity.ok(vehicleService.getAllVehicles());
			} catch (VehicleException e) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
			} catch(Exception ex) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
	}
}
