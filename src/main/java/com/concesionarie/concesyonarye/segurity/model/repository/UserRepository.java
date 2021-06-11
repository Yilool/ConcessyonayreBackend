package com.concesionarie.concesyonarye.segurity.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concesionarie.concesyonarye.segurity.model.entity.User;
import com.concesionarie.concesyonarye.segurity.model.enumerate.UserRoles;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the optional
	 */
	public Optional<User> findByUsername(String username);
	
	/**
	 * Find user by username.
	 *
	 * @param username the username
	 * @return the user
	 */
	public User findUserByUsername(String username);
	
	/**
	 * Find user by roles.
	 *
	 * @param rol the rol
	 * @return the list
	 */
	public List<User> findUserByRoles(UserRoles rol);
}
