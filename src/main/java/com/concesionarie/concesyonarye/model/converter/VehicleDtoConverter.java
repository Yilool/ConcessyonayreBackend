package com.concesionarie.concesyonarye.model.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concesionarie.concesyonarye.exception.ExceptionsCode;
import com.concesionarie.concesyonarye.exception.ModelException;
import com.concesionarie.concesyonarye.model.dto.RatingDto;
import com.concesionarie.concesyonarye.model.dto.VehicleDto;
import com.concesionarie.concesyonarye.model.entity.Model;
import com.concesionarie.concesyonarye.model.entity.Vehicle;
import com.concesionarie.concesyonarye.model.enumerate.Fuel;
import com.concesionarie.concesyonarye.model.repository.ModelRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class VehicleDtoConverter.
 */
@Component
public class VehicleDtoConverter {
	
	/** The Constant code. */
	private static final String code = "VEH0";
	
	/** The model repository. */
	@Autowired
	private ModelRepository modelRepository;
	
	/**
	 * From vehicle DTO to vehicle.
	 *
	 * @param vehicleDto the vehicle dto
	 * @return the vehicle
	 * @throws ModelException the model exception
	 */
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
	
	/**
	 * From vehicle to vehicle dto.
	 *
	 * @param vehicle the vehicle
	 * @return the vehicle dto
	 */
	public VehicleDto fromVehicleToVehicleDto(Vehicle vehicle) {
		VehicleDto vehicleDto = new VehicleDto();
		List<RatingDto> ratingDtos = new ArrayList<RatingDto>();
		
		vehicleDto.setCod(code + vehicle.getId());
		vehicleDto.setBasePrice(vehicle.getBasePrice());
		vehicleDto.setUserseats(vehicle.getUserseats());
		vehicleDto.setModel(vehicle.getModel().getModelName());
		vehicleDto.setFuel(vehicle.getFuel().toString());
		vehicleDto.setImagen(vehicle.getImagen());
		
		if (vehicle.getEnrollment() != null) {
			vehicleDto.setEnrollment(vehicle.getEnrollment());
		}
		
		vehicle.getRating().stream().forEach(rate -> {
			RatingDto ratingDto = new RatingDto();
			
			ratingDto.setRate(rate.getRate());
			ratingDto.setComment(rate.getComment());
			
			vehicleDto.setRate(vehicleDto.getRate() + rate.getRate());
			
			ratingDtos.add(ratingDto);
		});
		
		vehicleDto.setRates(ratingDtos);
		vehicleDto.setRate(vehicleDto.getRate() / vehicle.getRating().size());
		
		return vehicleDto;
	}
}
