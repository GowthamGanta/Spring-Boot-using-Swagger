package com.rs.fer.eis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.eis.entity.Role;

@Repository
public interface AssignmentsRepository extends JpaRepository<Role, Integer> {

	//List<EmployeeRoleAssignments> findById(int roleId);

}
