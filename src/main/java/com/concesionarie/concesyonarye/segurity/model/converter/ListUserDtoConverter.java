package com.concesionarie.concesyonarye.segurity.model.converter;

import org.springframework.stereotype.Component;

import com.concesionarie.concesyonarye.segurity.model.dto.ListUserDto;
import com.concesionarie.concesyonarye.segurity.model.entity.User;

@Component
public class ListUserDtoConverter {
	public ListUserDto fromUserToListUserDTO(User user) {
		ListUserDto listUserDto = new ListUserDto();
		
		listUserDto.setUsername(user.getUsername());
		listUserDto.setRoles(user.getRoles().toString());
		listUserDto.setCreateTime(user.getCreateTime());
		
		if (user.getDeleteTime() != null) {
			listUserDto.setDeleteTime(user.getDeleteTime());
		}
		
		return listUserDto;
	}
}
