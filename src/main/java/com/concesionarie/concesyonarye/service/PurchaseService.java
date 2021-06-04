package com.concesionarie.concesyonarye.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concesionarie.concesyonarye.exception.CustomerException;
import com.concesionarie.concesyonarye.exception.ExceptionsCode;
import com.concesionarie.concesyonarye.exception.PromotionException;
import com.concesionarie.concesyonarye.exception.PurchaseException;
import com.concesionarie.concesyonarye.exception.VehicleException;
import com.concesionarie.concesyonarye.model.converter.CustomerDtoConverter;
import com.concesionarie.concesyonarye.model.dto.CustomerDto;
import com.concesionarie.concesyonarye.model.dto.MsgDto;
import com.concesionarie.concesyonarye.model.dto.PurchaseDto;
import com.concesionarie.concesyonarye.model.entity.Customer;
import com.concesionarie.concesyonarye.model.entity.Promotion;
import com.concesionarie.concesyonarye.model.entity.Purchase;
import com.concesionarie.concesyonarye.model.entity.Vehicle;
import com.concesionarie.concesyonarye.model.repository.CustomerRepository;
import com.concesionarie.concesyonarye.model.repository.PromotionRepository;
import com.concesionarie.concesyonarye.model.repository.PurchaseRepository;
import com.concesionarie.concesyonarye.model.repository.VehicleRepository;
import com.concesionarie.concesyonarye.segurity.model.entity.User;
import com.concesionarie.concesyonarye.segurity.model.enumerate.UserRoles;
import com.concesionarie.concesyonarye.segurity.model.repository.UserRepository;

@Service("PurchaseService")
public class PurchaseService {
	@Autowired
	private PurchaseRepository purchaseRepository;
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private PromotionRepository promotionRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CustomerDtoConverter customerDtoConverter;
	
	public List<CustomerDto> getCustomers() {		
		List<User> customersUsers = userRepository.findAll();
		
		List<CustomerDto> customers = new ArrayList<>();
		
		customersUsers.stream().forEach(cu -> {
			if (cu.getRoles().contains(UserRoles.CUSTOM)) {				
				Customer customer = customerRepository.findCustomerByUser(cu);
				customers.add(customerDtoConverter.fromCustomerToCustomerDto(customer));
			}
		});
		
		return customers;
	}
	
	public MsgDto makePurchase(PurchaseDto purchaseDto) throws VehicleException, PurchaseException, CustomerException, PromotionException {
		MsgDto msg = new MsgDto();
		Vehicle vehicle = vehicleRepository.findVehicleById(Integer.parseInt(purchaseDto.getVehicle().substring(4)));
		Customer customer = customerRepository.findCustomerById(Integer.parseInt(purchaseDto.getCustomer().substring(4)));
		Promotion promotion = promotionRepository.findPromotionById(Integer.parseInt(purchaseDto.getPromotion().substring(4)));
		Purchase purchase;
		
		this.vehicleExist(vehicle);		
		this.customerExist(customer);
		this.promoExist(promotion);
		this.vehicleSelled(vehicle);
		this.enrollmentUsed(purchaseDto.getEnrollment());
		
		purchase = new Purchase(customer, vehicle, promotion);
		
		this.isFinacing(purchase, purchaseDto.getFinancing());
		
		this.setPrice(purchase, promotion, vehicle);
		
		vehicle.setEnrollment(purchaseDto.getEnrollment());
		
		vehicleRepository.save(vehicle);
		
		purchaseRepository.save(purchase);
		
		msg.setMsg("The customer " + customer.getFullname() + " have buy the vehicle with the enrollment " + vehicle.getEnrollment());
	
		return msg;
	}
	
	private void customerExist(Customer custom) throws CustomerException {
		if (custom == null) {
			throw new CustomerException(ExceptionsCode.CUSTOMER_NOT_EXISTS);
		}
	}
	
	private void promoExist(Promotion promotion) throws PromotionException {
		if (promotion == null) {
			throw new PromotionException(ExceptionsCode.PROMOTION_NOT_EXISTS);
		} 
	}
	
	private void vehicleExist(Vehicle vehicle) throws VehicleException {
		if (vehicle == null) {
			throw new VehicleException(ExceptionsCode.VEHICLE_NOT_EXISTS);
		}
	}
	
	private void vehicleSelled(Vehicle vehicle) throws PurchaseException {
		if (vehicle.getEnrollment() != null) {
			throw new PurchaseException(ExceptionsCode.VEHICLE_SELLED);
		}
	}
	
	private void enrollmentUsed(String enrollment) throws PurchaseException {
		Vehicle enrol = vehicleRepository.findVehicleByEnrollment(enrollment);
		
		if (enrol != null) {
			throw new PurchaseException(ExceptionsCode.ENROLLMENT_USED);
		}
	}
	
	private Purchase isFinacing(Purchase purchase, boolean financing) {
		if (financing) {
			purchase.setFinalPaymentDate(null);
		} else {
			purchase.setFinalPaymentDate(LocalDate.now());
		}
		
		return purchase;
	}
	
	private Purchase setPrice(Purchase purchase, Promotion promotion, Vehicle vehicle) {
		double discount = (promotion.getDiscountPercent() / Promotion.getBuyDiscount()) / 100;
		double price = vehicle.getBasePrice() + this.getIVA(vehicle.getBasePrice());
		
		purchase.setFinalPrice(this.getDiscount(price, discount));
		
		return purchase;
	}
	
	private double getIVA(double price) {
		double iva = 0.21;
		
		return price * iva;
	}
	
	private double getDiscount(double price, double discount) {
		return price - (price * discount);
	}
}
