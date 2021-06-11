package com.concesionarie.concesyonarye.segurity.model.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class ListUserDto.
 */
@JsonInclude(Include.NON_NULL)
public class ListUserDto {
	
	/** The username. */
	private String username;
	
	/** The roles. */
	private String roles;
	
	/** The create time. */
	private LocalDateTime createTime;

	/** The delete time. */
	private LocalDateTime deleteTime;

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the creates the time.
	 *
	 * @return the creates the time
	 */
	public LocalDateTime getCreateTime() {
		return createTime;
	}

	/**
	 * Sets the creates the time.
	 *
	 * @param createTime the new creates the time
	 */
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	/**
	 * Gets the delete time.
	 *
	 * @return the delete time
	 */
	public LocalDateTime getDeleteTime() {
		return deleteTime;
	}

	/**
	 * Sets the delete time.
	 *
	 * @param deleteTime the new delete time
	 */
	public void setDeleteTime(LocalDateTime deleteTime) {
		this.deleteTime = deleteTime;
	}

	/**
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	public String getRoles() {
		return roles;
	}

	/**
	 * Sets the roles.
	 *
	 * @param roles the new roles
	 */
	public void setRoles(String roles) {
		this.roles = roles;
	}
}
