package com.concesionarie.concesyonarye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concesionarie.concesyonarye.model.entity.Model;

// TODO: Auto-generated Javadoc
/**
 * The Interface ModelRepository.
 */
@Repository
public interface ModelRepository extends JpaRepository<Model, Integer>{
	
	/**
	 * Find model by model name.
	 *
	 * @param modelName the model name
	 * @return the model
	 */
	public Model findModelByModelName(String modelName);
	
	/**
	 * Find model by id.
	 *
	 * @param id the id
	 * @return the model
	 */
	public Model findModelById(Integer id);
}
