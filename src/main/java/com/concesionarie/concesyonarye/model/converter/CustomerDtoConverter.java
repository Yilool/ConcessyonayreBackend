package com.concesionarie.concesyonarye.model.converter;

import org.springframework.stereotype.Component;

import com.concesionarie.concesyonarye.model.dto.CustomerDto;
import com.concesionarie.concesyonarye.model.entity.Customer;

@Component
public class CustomerDtoConverter {
	private static final String code = "CUS0";
	
	public CustomerDto fromCustomerToCustomerDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		
		customerDto.setCod(code + customer.getId());
		customerDto.setFullname(customer.getFullname());
		customerDto.setDni(customer.getDni());
		
		return customerDto;
	}
}
