package com.concesionarie.concesyonarye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concesionarie.concesyonarye.model.entity.Rating;

/**
 * The Interface RatingRepository.
 */
@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
	
}
