package com.concesionarie.concesyonarye.segurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.concesionarie.concesyonarye.exception.UserException;
import com.concesionarie.concesyonarye.segurity.model.dto.CustomerUserDto;
import com.concesionarie.concesyonarye.segurity.model.dto.ListUserDto;
import com.concesionarie.concesyonarye.segurity.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	
	/** The user service. */
	@Autowired
	private UserService userService;
	
	/**
	 * Sign up.
	 *
	 * @param userDTO the user DTO
	 * @return the response entity
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody CustomerUserDto userDTO) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.createNewUser(userDTO));
		} catch (UserException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Sign in.
	 *
	 * @param userDTO the user DTO
	 * @return the response entity
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@RequestBody CustomerUserDto userDTO) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.createNewCustomerUser(userDTO));
		} catch (UserException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Login.
	 *
	 * @param userDTO the user DTO
	 * @return the response entity
	 */
	@PostMapping("/login")
	public ResponseEntity<CustomerUserDto> login(@RequestBody CustomerUserDto userDTO){
		
		return ResponseEntity.status(HttpStatus.OK).body(userDTO);
	}
	
	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	@GetMapping
	public ResponseEntity<?> getUsers() {
		ResponseEntity<?> response;

		try {
			List<ListUserDto> results = userService.getAllUsers();
			response = ResponseEntity.ok(results);
		} catch (UserException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch (Exception e) {
			response = ResponseEntity.badRequest().body(e.getMessage());
		}

		return response;
	}
	
	/**
	 * Delete user.
	 *
	 * @param username the username
	 * @return the response entity
	 */
	@DeleteMapping(path = "/{username}")
	public ResponseEntity<?> deleteUser(@PathVariable String username) {
		ResponseEntity<?> response;

		try {
			CustomerUserDto customerUserDto = userService.deleteUser(username);
			response = ResponseEntity.ok(customerUserDto);
		} catch (UserException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch (Exception e) {
			response = ResponseEntity.badRequest().body(e.getMessage());
		}

		return response;
	}
}
