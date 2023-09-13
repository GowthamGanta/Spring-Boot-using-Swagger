package com.rs.fer.eis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.eis.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	//List<Department> findById(int Id);

	// List<Department> findByDepartmentName(String departmentName);

}







