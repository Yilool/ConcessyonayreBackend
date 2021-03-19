package com.concesionarie.concesyonarye.model.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.concesionarie.concesyonarye.model.dto.CustomerUserDto;
import com.concesionarie.concesyonarye.model.entity.User;
import com.concesionarie.concesyonarye.model.enumerate.UserRoles;

@Component
public class CustomerUserDtoConverter {
	
	@Autowired
	private PasswordEncoder encoder;
	
	public User fromCustomerUserDTOToUser(CustomerUserDto customerUserDto) {
		User user = new User(customerUserDto.getUsername(), encoder.encode(customerUserDto.getPassword()), 
				UserRoles.valueOf(customerUserDto.getRoles()), 
				customerUserDto.getName(), customerUserDto.getSurname(), 
				customerUserDto.getBankaccount(), customerUserDto.getAddress(), 
				customerUserDto.getTlf(), customerUserDto.getDni());
		
		return user;
	}
	
	public CustomerUserDto fromUserToCustomerUserDto(User user) {
		CustomerUserDto customerUserDto = new CustomerUserDto();
		
		customerUserDto.setUsername(user.getUsername());
		
		return customerUserDto;
	}
}
