package com.rs.fer.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.eis.entity.EmployeeRole;
import com.rs.fer.eis.entity.Role;
import com.rs.fer.eis.repository.AssignmentsRepository;
import com.rs.fer.eis.repository.EmployeeRoleRepository;
import com.rs.fer.eis.request.AddAssignmentsRequest;
import com.rs.fer.eis.response.AddAssignmentsResponse;
import com.rs.fer.eis.service.AssignmentsService;
import com.rs.fer.eis.util.AssignmentsUtil;

@Service
public class AssignmentsServiveImpl implements AssignmentsService {
	
	@Autowired
	AssignmentsUtil assignmentsUtil;
	
	@Autowired
	AssignmentsRepository assignmentsRepository;
	
	@Autowired
	EmployeeRoleRepository employeeRoleRepository;

	
	@Override
	public AddAssignmentsResponse addAssignments(AddAssignmentsRequest request) {

		AddAssignmentsResponse response = null;

		Optional<EmployeeRole> employeeRoleObj = employeeRoleRepository.findById(request.getRoleId());

		if (employeeRoleObj.isPresent()) {
			// load vo to bean
			Role role = assignmentsUtil.loadAddAssignmentsRequestToAssignments(request);
			EmployeeRole employeeRole = employeeRoleObj.get();
			employeeRole.getRoles().add(role);
			// save bean to database
			employeeRole = employeeRoleRepository.save(employeeRole);

			response = new AddAssignmentsResponse(HttpStatus.OK, "000", "Assignments Added succesfully ", null);
			response.setAssignments(role);

		} else {
			// failure
			response = new AddAssignmentsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Employee is not present", null);
		}
		return response;

	}

}
