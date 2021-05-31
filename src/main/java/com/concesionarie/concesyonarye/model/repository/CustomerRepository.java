package com.concesionarie.concesyonarye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concesionarie.concesyonarye.model.entity.Customer;
import com.concesionarie.concesyonarye.segurity.model.entity.User;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	public Customer findCustomerByUser(User user);
	
	public Customer findCustomerById(Integer id);
}
