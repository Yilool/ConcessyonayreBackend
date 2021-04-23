package com.concesionarie.concesyonarye.segurity.model.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.concesionarie.concesyonarye.segurity.model.dto.CustomerUserDto;
import com.concesionarie.concesyonarye.segurity.model.entity.User;
import com.concesionarie.concesyonarye.segurity.model.enumerate.UserRoles;

@Component
public class CustomerUserDtoConverter {
	
	@Autowired
	private PasswordEncoder encoder;
	
	public User fromCustomerUserDTOToCustomerUser(CustomerUserDto customerUserDto) {
		User user = new User(customerUserDto.getUsername(), encoder.encode(customerUserDto.getPassword()),
				customerUserDto.getName(), customerUserDto.getSurname(), 
				customerUserDto.getBankaccount(), customerUserDto.getAddress(), 
				customerUserDto.getTlf(), customerUserDto.getDni());
		
		return user;
	}
	
	public User fromCustomerUserDTOToUser(CustomerUserDto userDto) {
		User user = new User(userDto.getUsername(), encoder.encode(userDto.getPassword()), 
				UserRoles.valueOf(userDto.getRoles()));
		
		return user;
	}
	
	public CustomerUserDto fromUserToCustomerUserDto(User user) {
		CustomerUserDto customerUserDto = new CustomerUserDto();
		
		customerUserDto.setUsername(user.getUsername());
		
		return customerUserDto;
	}
}
