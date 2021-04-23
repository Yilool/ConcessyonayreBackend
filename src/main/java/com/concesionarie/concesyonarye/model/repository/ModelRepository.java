package com.concesionarie.concesyonarye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concesionarie.concesyonarye.model.entity.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer>{
	public Model findModelByModelName(String modelName);
	public Model findModelById(Integer id);
}
