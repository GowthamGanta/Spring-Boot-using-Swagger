package com.rs.fer.eis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.eis.entity.Experience_Details;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience_Details, Integer>  {
	Optional<Experience_Details> findById(int employeeId);
	

}
