package com.rs.fer.eis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.eis.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//List<User> findByUsernameAndPassword(String username, String password);

	List<Employee> findByEmail(String email);
	
	List<Employee> findByEmployeeId(int employeeId);
	
	// List<User> findByUserIdAndPassword(int userId,String password);

	//List<User> findByUserIdAndPassword(int userId, String password);

	//List<User> findByBlockStatus(String BlockStatus);

	//List<User> findByEmailAndUserIdNot(String email, int userId);

}

