package com.concesionarie.concesyonarye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concesionarie.concesyonarye.model.entity.Model;
import com.concesionarie.concesyonarye.model.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
	public Vehicle findVehicleById(Integer id);
	
	public Vehicle findVehicleByModel(Model model);
	
	public Vehicle findVehicleByEnrollment(String enrollment);
}
