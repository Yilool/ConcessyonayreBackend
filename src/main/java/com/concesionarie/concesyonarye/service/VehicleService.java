package com.concesionarie.concesyonarye.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concesionarie.concesyonarye.exception.ExceptionsCode;
import com.concesionarie.concesyonarye.exception.ModelException;
import com.concesionarie.concesyonarye.exception.VehicleException;
import com.concesionarie.concesyonarye.model.converter.VehicleDtoConverter;
import com.concesionarie.concesyonarye.model.dto.VehicleDto;
import com.concesionarie.concesyonarye.model.entity.Vehicle;
import com.concesionarie.concesyonarye.model.repository.VehicleRepository;

import ch.qos.logback.core.pattern.Converter;

@Service("VehicleService")
public class VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private VehicleDtoConverter vehicleDtoConverter;
	
	public VehicleDto registerNewVehicle(VehicleDto vehicleDto) throws ModelException {
		Vehicle vehicle = null;
		
		vehicle = vehicleDtoConverter.fromVehicleDTOToVehicle(vehicleDto);
		
		return vehicleDtoConverter.fromVehicleToVehicleDto(vehicleRepository.save(vehicle));
	}
	
	public VehicleDto getVehicle(String cod) throws VehicleException {
		Vehicle vehicles = vehicleRepository.findVehicleById(Integer.parseInt(cod.substring(4)));
		
		if (vehicles == null) {
			throw new VehicleException(ExceptionsCode.NOT_VEHICLES);
		}
		
		return vehicleDtoConverter.fromVehicleToVehicleDto(vehicles);
	}
	
	public List<VehicleDto> getAllVehicles() throws VehicleException {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		
		if (vehicles.size() == 0) {
			throw new VehicleException(ExceptionsCode.NOT_VEHICLES);
		}
		
		List<VehicleDto> vehiclesDtos = new ArrayList<>();
		
		vehicles.stream().forEach(vehicle -> {
			VehicleDto vehicleDto = vehicleDtoConverter.fromVehicleToVehicleDto(vehicle);
			vehiclesDtos.add(vehicleDto);
		});	
		
		return vehiclesDtos;
	}
}
