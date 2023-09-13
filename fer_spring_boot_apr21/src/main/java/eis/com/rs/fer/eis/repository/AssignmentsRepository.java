package com.rs.fer.eis.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.eis.entity.EmployeeRoleAssignments;

@Repository
public interface AssignmentsRepository extends JpaRepository<EmployeeRoleAssignments, Integer> {

	//List<EmployeeRoleAssignments> findById(int roleId);

}
