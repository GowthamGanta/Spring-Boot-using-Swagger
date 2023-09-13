package com.rs.fer.eis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.entity.EmployeeSkills;

@Repository
public interface EmployeeSkillsRepository extends JpaRepository<EmployeeSkills, Integer> {

	List<Employee> findById(int id);
	

}
