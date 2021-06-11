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

// TODO: Auto-generated Javadoc
/**
 * The Class VehicleService.
 */
@Service("VehicleService")
public class VehicleService {
	
	/** The vehicle repository. */
	@Autowired
	private VehicleRepository vehicleRepository;
	
	/** The vehicle dto converter. */
	@Autowired
	private VehicleDtoConverter vehicleDtoConverter;
	
	/**
	 * Register new vehicle.
	 *
	 * @param vehicleDto the vehicle dto
	 * @return the vehicle dto
	 * @throws ModelException the model exception
	 */
	public VehicleDto registerNewVehicle(VehicleDto vehicleDto) throws ModelException {
		Vehicle vehicle = null;
		
		vehicle = vehicleDtoConverter.fromVehicleDTOToVehicle(vehicleDto);
		
		return vehicleDtoConverter.fromVehicleToVehicleDto(vehicleRepository.save(vehicle));
	}
	
	/**
	 * Gets the vehicle.
	 *
	 * @param cod the cod
	 * @return the vehicle
	 * @throws VehicleException the vehicle exception
	 */
	public VehicleDto getVehicle(String cod) throws VehicleException {
		Vehicle vehicles = vehicleRepository.findVehicleById(Integer.parseInt(cod.substring(4)));
		
		if (vehicles == null) {
			throw new VehicleException(ExceptionsCode.NOT_VEHICLES);
		}
		
		return vehicleDtoConverter.fromVehicleToVehicleDto(vehicles);
	}
	
	/**
	 * Gets the all vehicles.
	 *
	 * @return the all vehicles
	 * @throws VehicleException the vehicle exception
	 */
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
