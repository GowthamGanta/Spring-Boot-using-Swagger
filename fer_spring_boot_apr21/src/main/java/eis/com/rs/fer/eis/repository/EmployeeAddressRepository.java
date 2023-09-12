package com.rs.fer.eis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.eis.entity.EmployeeAddress;

@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, Integer> {

	// List<EmployeeAddress> findByEmployeeId(int employeeId);

}