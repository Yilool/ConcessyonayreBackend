package com.concesionarie.concesyonarye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concesionarie.concesyonarye.model.entity.Model;
import com.concesionarie.concesyonarye.model.entity.Vehicle;

// TODO: Auto-generated Javadoc
/**
 * The Interface VehicleRepository.
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
	
	/**
	 * Find vehicle by id.
	 *
	 * @param id the id
	 * @return the vehicle
	 */
	public Vehicle findVehicleById(Integer id);
	
	/**
	 * Find vehicle by model.
	 *
	 * @param model the model
	 * @return the vehicle
	 */
	public Vehicle findVehicleByModel(Model model);
	
	/**
	 * Find vehicle by enrollment.
	 *
	 * @param enrollment the enrollment
	 * @return the vehicle
	 */
	public Vehicle findVehicleByEnrollment(String enrollment);
}
