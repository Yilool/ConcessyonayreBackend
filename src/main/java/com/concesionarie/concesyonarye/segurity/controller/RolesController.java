package com.concesionarie.concesyonarye.segurity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concesionarie.concesyonarye.segurity.model.enumerate.UserRoles;

@CrossOrigin
@RestController
@RequestMapping("/roles")
public class RolesController {
	@GetMapping
	public ResponseEntity<?> getRoles() {
		ResponseEntity<?> response;
		List<String> roles = new ArrayList<>();
				
		//Arrays.stream(UserRoles.values()).map(r -> new String[] {r.name()}).collect(Collectors.toList()).toArray();
		
		roles.add(UserRoles.CUSTOM.name());
		roles.add(UserRoles.ADMIN.name());
		roles.add(UserRoles.HIRER.name());
		roles.add(UserRoles.MECHANIC.name());
		roles.add(UserRoles.SELLER.name());
		
		response = ResponseEntity.ok(roles);
		
		return response;
	}
}
