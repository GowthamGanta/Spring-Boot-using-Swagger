package com.rs.fer.eis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.eis.entity.EducationalDetails;

@Repository
public interface EducationalDetailsRepository extends JpaRepository<EducationalDetails, Integer> {
	List<EducationalDetails> findByEmployeeId(int employeeId);
}