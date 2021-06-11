package com.concesionarie.concesyonarye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concesionarie.concesyonarye.model.entity.Customer;
import com.concesionarie.concesyonarye.model.entity.Promotion;
import com.concesionarie.concesyonarye.model.entity.Purchase;
import com.concesionarie.concesyonarye.model.entity.Vehicle;

// TODO: Auto-generated Javadoc
/**
 * The Interface PurchaseRepository.
 */
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{
	
	/**
	 * Find purchase by id.
	 *
	 * @param id the id
	 * @return the purchase
	 */
	public Purchase findPurchaseById(Integer id);
	
	/**
	 * Find purchase by customer.
	 *
	 * @param customer the customer
	 * @return the purchase
	 */
	public Purchase findPurchaseByCustomer(Customer customer);
	
	/**
	 * Find purchase by vehicle.
	 *
	 * @param vehicle the vehicle
	 * @return the purchase
	 */
	public Purchase findPurchaseByVehicle(Vehicle vehicle);
	
	/**
	 * Find purchase by promotion.
	 *
	 * @param promotion the promotion
	 * @return the purchase
	 */
	public Purchase findPurchaseByPromotion(Promotion promotion);
}
