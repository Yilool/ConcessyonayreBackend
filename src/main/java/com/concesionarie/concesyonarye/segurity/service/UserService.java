package com.concesionarie.concesyonarye.segurity.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.concesionarie.concesyonarye.exception.ExceptionsCode;
import com.concesionarie.concesyonarye.exception.UserException;
import com.concesionarie.concesyonarye.model.entity.Customer;
import com.concesionarie.concesyonarye.model.repository.CustomerRepository;
import com.concesionarie.concesyonarye.segurity.model.converter.CustomerUserDtoConverter;
import com.concesionarie.concesyonarye.segurity.model.converter.ListUserDtoConverter;
import com.concesionarie.concesyonarye.segurity.model.dto.CustomerUserDto;
import com.concesionarie.concesyonarye.segurity.model.dto.ListUserDto;
import com.concesionarie.concesyonarye.segurity.model.entity.User;
import com.concesionarie.concesyonarye.segurity.model.repository.UserRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UserService.
 */
@Service("UserService")
public class UserService implements UserDetailsService{
	
	/** The user repo. */
	@Autowired
	private UserRepository userRepo;
	
	/** The custom repo. */
	@Autowired
	private CustomerRepository customRepo;
	
	/** The custom user converter. */
	@Autowired
	private CustomerUserDtoConverter customUserConverter;
	
	/** The list user converter. */
	@Autowired
	private ListUserDtoConverter listUserConverter;
	
	/**
	 * Load user by username.
	 *
	 * @param username the username
	 * @return the user details
	 * @throws UsernameNotFoundException the username not found exception
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepo.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	}
	
	/**
	 * Load user by id.
	 *
	 * @param id the id
	 * @return the user details
	 * @throws AuthenticationException the authentication exception
	 */
	public UserDetails loadUserById(Integer id) throws AuthenticationException {
		return userRepo.findById(id)
				.orElseThrow(()-> new AuthenticationException("Id not found"));
	}

	/**
	 * Creates the new customer user.
	 *
	 * @param customerUserDto the customer user dto
	 * @return the customer user dto
	 * @throws UserException the user exception
	 */
	public CustomerUserDto createNewCustomerUser(CustomerUserDto customerUserDto) throws UserException{
		User user;
		// = userRepo.save(customUserConverter.fromCustomerUserDTOToCustomerUser(customerUserDto))
		if (userRepo.findUserByUsername(customerUserDto.getUsername()) != null) {
			throw new UserException(ExceptionsCode.USER_EXISTS);
		} else {
			user = userRepo.save(customUserConverter.fromCustomerUserDTOToCustomerUser(customerUserDto));
			
			Customer customer = customRepo.save(user.getCustomer());
			
			user.setCustomer(customer);
		}
		
		return customUserConverter.fromUserToCustomerUserDto(userRepo.save(user));
	}
	
	/**
	 * Creates the new user.
	 *
	 * @param userDto the user dto
	 * @return the customer user dto
	 * @throws UserException the user exception
	 */
	public CustomerUserDto createNewUser(CustomerUserDto userDto) throws UserException{
		User user;
		
		if (userRepo.findUserByUsername(userDto.getUsername()) != null) {
			throw new UserException(ExceptionsCode.USER_EXISTS);
		} else {
			user = userRepo.save(customUserConverter.fromCustomerUserDTOToUser(userDto));
		}
		
		
		return customUserConverter.fromUserToCustomerUserDto(userRepo.save(user));
	}
	
	/**
	 * Delete user.
	 *
	 * @param username the username
	 * @return the customer user dto
	 * @throws UserException the user exception
	 */
	public CustomerUserDto deleteUser(String username) throws UserException{
		User user = userRepo.findUserByUsername(username);
		
		if (user == null) {
			throw new UserException(ExceptionsCode.USER_NOT_EXISTS);
		}
		
		user.setDeleteTime(LocalDateTime.now());
		
		return customUserConverter.fromUserToCustomerUserDto(userRepo.save(user));
	}
	
	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 * @throws UserException the user exception
	 */
	public List<ListUserDto> getAllUsers() throws UserException {
		List<User> result = (List<User>) userRepo.findAll();

		if (result.size() == 0) {
			throw new UserException(ExceptionsCode.NOT_USERS);
		}
		
		List<ListUserDto> listUserDTOS = new ArrayList<>();
		
		result.stream().forEach(user -> {
			ListUserDto listUserDto = listUserConverter.fromUserToListUserDTO(user);
			listUserDTOS.add(listUserDto);
		});

		return listUserDTOS;
	}
}
