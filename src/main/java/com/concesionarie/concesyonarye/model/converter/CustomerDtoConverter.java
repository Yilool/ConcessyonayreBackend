package com.concesionarie.concesyonarye.model.converter;

import org.springframework.stereotype.Component;

import com.concesionarie.concesyonarye.model.dto.CustomerDto;
import com.concesionarie.concesyonarye.model.entity.Customer;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerDtoConverter.
 */
@Component
public class CustomerDtoConverter {
	
	/** The Constant code. */
	private static final String code = "CUS0";
	
	/**
	 * From customer to customer dto.
	 *
	 * @param customer the customer
	 * @return the customer dto
	 */
	public CustomerDto fromCustomerToCustomerDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		
		customerDto.setCod(code + customer.getId());
		customerDto.setFullname(customer.getFullname());
		customerDto.setDni(customer.getDni());
		
		return customerDto;
	}
}
