package com.concesionarie.concesyonarye.model.converter;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concesionarie.concesyonarye.exception.ExceptionsCode;
import com.concesionarie.concesyonarye.exception.ModelException;
import com.concesionarie.concesyonarye.model.dto.VehicleDto;
import com.concesionarie.concesyonarye.model.entity.Model;
import com.concesionarie.concesyonarye.model.entity.Vehicle;
import com.concesionarie.concesyonarye.model.enumerate.Fuel;
import com.concesionarie.concesyonarye.model.repository.ModelRepository;

@Component
public class VehicleDtoConverter {
	private static final String code = "VEH0";
	
	@Autowired
	private ModelRepository modelRepository;
	
	public Vehicle fromVehicleDTOToVehicle(VehicleDto vehicleDto) throws ModelException {
		Vehicle vehicle;
		
		Model model = modelRepository.findModelByModelName(vehicleDto.getModel().toUpperCase());
		
		if (model == null) {
			throw new ModelException(ExceptionsCode.MODEL_NOT_EXISTS);
		}
		
		vehicle = new Vehicle(vehicleDto.getBasePrice(), vehicleDto.getUserseats(),	Fuel.valueOf(vehicleDto.getFuel()), model);	
		
		vehicle.setImagen(Base64.decodeBase64((String) vehicleDto.getPhoto()));
		
		return vehicle;
	}
	
	public VehicleDto fromVehicleToVehicleDto(Vehicle vehicle) {
		VehicleDto vehicleDto = new VehicleDto();
		
		vehicleDto.setCod(code + vehicle.getId());
		vehicleDto.setBasePrice(vehicle.getBasePrice());
		vehicleDto.setUserseats(vehicle.getUserseats());
		vehicleDto.setModel(vehicle.getModel().getModelName());
		vehicleDto.setFuel(vehicle.getFuel().toString());
		vehicleDto.setImagen(vehicle.getImagen());
		
		if (vehicle.getEnrollment() != null) {
			vehicleDto.setEnrollment(vehicle.getEnrollment());
		}
		
		return vehicleDto;
	}
}
