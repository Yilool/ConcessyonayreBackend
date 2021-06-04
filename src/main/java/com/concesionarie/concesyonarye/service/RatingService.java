package com.concesionarie.concesyonarye.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concesionarie.concesyonarye.exception.CustomerException;
import com.concesionarie.concesyonarye.exception.ExceptionsCode;
import com.concesionarie.concesyonarye.exception.PurchaseException;
import com.concesionarie.concesyonarye.exception.VehicleException;
import com.concesionarie.concesyonarye.model.converter.VehicleDtoConverter;
import com.concesionarie.concesyonarye.model.dto.MsgDto;
import com.concesionarie.concesyonarye.model.dto.RatingDto;
import com.concesionarie.concesyonarye.model.dto.VehicleDto;
import com.concesionarie.concesyonarye.model.entity.Customer;
import com.concesionarie.concesyonarye.model.entity.Purchase;
import com.concesionarie.concesyonarye.model.entity.Rating;
import com.concesionarie.concesyonarye.model.entity.Vehicle;
import com.concesionarie.concesyonarye.model.repository.CustomerRepository;
import com.concesionarie.concesyonarye.model.repository.PurchaseRepository;
import com.concesionarie.concesyonarye.model.repository.RatingRepository;
import com.concesionarie.concesyonarye.model.repository.VehicleRepository;

@Service("RatingService")
public class RatingService {
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private VehicleDtoConverter vehicleDtoConverter;
	
	public List<VehicleDto> getCustomerVehicles(int cus) throws PurchaseException, CustomerException {
		List<Purchase> purchases = purchaseRepository.findAll();
		Customer customer = customerRepository.findCustomerById(cus);
		
		this.havePurchase(purchases);
		this.customerExist(customer);
		
		List<VehicleDto> vehicleDtos = this.customVehicles(purchases, customer);
		
		return vehicleDtos;
	}
	
	public MsgDto rateVehicle(RatingDto ratingDto) throws CustomerException, VehicleException {
		Vehicle vehicle = vehicleRepository.findVehicleById(Integer.parseInt(ratingDto.getVehicle().substring(4)));
		Customer customer = customerRepository.findCustomerById(ratingDto.getCustomer());
		Rating rating;
		MsgDto msg = new MsgDto();
		
		this.customerExist(customer);
		this.vehicleExist(vehicle);
		
		rating = new Rating(vehicle, customer);
		
		rating.setRate(ratingDto.getRate());
		rating.setComment(ratingDto.getComment());
		
		ratingRepository.save(rating);
		
		msg.setMsg("You have rate the model " + vehicle.getModel().getModelName() + " of the brand " + vehicle.getModel().getBrand().getBrandName());
		
		return msg;
	}
	
	private void vehicleExist(Vehicle vehicle) throws VehicleException {
		if (vehicle == null) {
			throw new VehicleException(ExceptionsCode.VEHICLE_NOT_EXISTS);
		}
	}
	
	private void customerExist(Customer custom) throws CustomerException {
		if (custom == null) {
			throw new CustomerException(ExceptionsCode.CUSTOMER_NOT_EXISTS);
		}
	}
	
	private void havePurchase(List<Purchase> purchases) throws PurchaseException {
		if (purchases.isEmpty()) {
			throw new PurchaseException(ExceptionsCode.NOT_PURCHASES);
		}
	}
	
	private List<VehicleDto> customVehicles(List<Purchase> purchases, Customer custom) {
		List<VehicleDto> vehicleDtos = new ArrayList<>();
		
		purchases.stream().forEach(purchase -> {
			if (purchase.getCustomer() == custom) {
				Vehicle vehicle = purchase.getVehicle();
				
				VehicleDto vehicleDto = vehicleDtoConverter.fromVehicleToVehicleDto(vehicle);
				
				vehicleDtos.add(vehicleDto);
			}
		});
		
		return vehicleDtos;
	}
}
