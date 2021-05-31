package com.concesionarie.concesyonarye.segurity.model.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concesionarie.concesyonarye.segurity.model.entity.User;
import com.concesionarie.concesyonarye.segurity.model.enumerate.UserRoles;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	public Optional<User> findByUsername(String username);
	
	public User findUserByUsername(String username);
	
	public List<User> findUserByRoles(UserRoles rol);
}
