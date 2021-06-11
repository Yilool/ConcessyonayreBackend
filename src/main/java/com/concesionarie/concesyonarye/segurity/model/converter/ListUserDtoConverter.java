package com.concesionarie.concesyonarye.segurity.model.converter;

import org.springframework.stereotype.Component;

import com.concesionarie.concesyonarye.segurity.model.dto.ListUserDto;
import com.concesionarie.concesyonarye.segurity.model.entity.User;

// TODO: Auto-generated Javadoc
/**
 * The Class ListUserDtoConverter.
 */
@Component
public class ListUserDtoConverter {
	
	/**
	 * From user to list user DTO.
	 *
	 * @param user the user
	 * @return the list user dto
	 */
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
