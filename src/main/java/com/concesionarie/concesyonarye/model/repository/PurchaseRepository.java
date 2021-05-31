package com.concesionarie.concesyonarye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concesionarie.concesyonarye.model.entity.Customer;
import com.concesionarie.concesyonarye.model.entity.Promotion;
import com.concesionarie.concesyonarye.model.entity.Purchase;
import com.concesionarie.concesyonarye.model.entity.Vehicle;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{
	public Purchase findPurchaseById(Integer id);
	
	public Purchase findPurchaseByCustomer(Customer customer);
	
	public Purchase findPurchaseByVehicle(Vehicle vehicle);
	
	public Purchase findPurchaseByPromotion(Promotion promotion);
}
