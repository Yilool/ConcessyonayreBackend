package com.concesionarie.concesyonarye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concesionarie.concesyonarye.model.entity.Customer;
import com.concesionarie.concesyonarye.segurity.model.entity.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface CustomerRepository.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	/**
	 * Find customer by user.
	 *
	 * @param user the user
	 * @return the customer
	 */
	public Customer findCustomerByUser(User user);
	
	/**
	 * Find customer by id.
	 *
	 * @param id the id
	 * @return the customer
	 */
	public Customer findCustomerById(Integer id);
}
