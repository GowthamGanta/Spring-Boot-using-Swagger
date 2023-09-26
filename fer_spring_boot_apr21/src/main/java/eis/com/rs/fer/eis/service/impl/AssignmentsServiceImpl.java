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
import com.rs.fer.eis.request.DeleteAssignmentsRequest;
import com.rs.fer.eis.request.EditAssignmentsRequest;
import com.rs.fer.eis.request.GetAssignmentsOptionsRequest;
import com.rs.fer.eis.request.GetAssignmentsRequest;
import com.rs.fer.eis.response.AddAssignmentsResponse;
import com.rs.fer.eis.response.DeleteAssignmentsResponse;
import com.rs.fer.eis.response.EditAssignmentsResponse;
import com.rs.fer.eis.response.GetAssignmentsOptionsResponse;
import com.rs.fer.eis.response.GetAssignmentsResponse;
import com.rs.fer.eis.service.AssignmentsService;
import com.rs.fer.eis.util.AssignmentsUtil;

@Service
public class AssignmentsServiceImpl implements AssignmentsService {

	@Autowired
	AssignmentsUtil assignmentsUtil;

	@Autowired
	AssignmentsRepository assignmentsRepository;

	@Autowired
	EmployeeRoleRepository employeeRoleRepository;

	private EmployeeRole role;

	@Override
	public AddAssignmentsResponse addAssignments(AddAssignmentsRequest request) {

		AddAssignmentsResponse response = null;

		Optional<EmployeeRole> employeeRoleObj = employeeRoleRepository.findById(request.getRoleId());

		if (employeeRoleObj.isPresent()) {
			// load vo to bean
			Role role = assignmentsUtil.loadAddAssignmentsRequestToAssignments(request);
			EmployeeRole employeeRole = employeeRoleObj.get();
			employeeRole.setRole(role);
			// save bean to database
			employeeRole = employeeRoleRepository.save(employeeRole);

			response = new AddAssignmentsResponse(HttpStatus.OK, "000", "Assignments Added Succesfully ", null);
			response.setAssignments(role);

		} else {
			// failure
			response = new AddAssignmentsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Assignments is not present",
					null);
		}
		return response;

	}

	@Override
	public EditAssignmentsResponse editAssignments(EditAssignmentsRequest request) {
		EditAssignmentsResponse response = null;

		// User is present or not check
		Optional<EmployeeRole> employeeRoleObj = employeeRoleRepository.findById(request.getId());

		if (employeeRoleObj.isPresent()) {
			// load vo to bean
			Role role = assignmentsUtil.loadEditAssignmentsRequestToAssignments(request);
			EmployeeRole employeeRole = employeeRoleObj.get();
			employeeRole.setRole(role);
			// save bean to database
			employeeRole = employeeRoleRepository.save(employeeRole);

			response = new EditAssignmentsResponse(HttpStatus.OK, "000", "Assignments Edited Succesfully ", null);
			response.setAssignments(role);

		} else {
			// failure
			response = new EditAssignmentsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Assignments is not present",
					null);
		}
		return response;

	}

	@Override
	public DeleteAssignmentsResponse deleteAssignments(DeleteAssignmentsRequest request) {
		DeleteAssignmentsResponse response = null;

		Optional<EmployeeRole> employeeRoleObj = employeeRoleRepository.findById(request.getId());

		if (employeeRoleObj.isPresent()) {

			// Delete Address based on Address id
			employeeRoleRepository.deleteById(request.getId());

			// if Address is deleted success case
			response = new DeleteAssignmentsResponse(HttpStatus.OK, "000", "Assignments is succesfully Deleted", null);
			response.setAssignments(role);
		} else {
			// if Address is deleted failure case
			response = new DeleteAssignmentsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002",
					"Delete Assignments is failed", null);
		}

		return response;
	}

	@Override
	public GetAssignmentsOptionsResponse getAssignmentsOptions(GetAssignmentsOptionsRequest request) {
		GetAssignmentsOptionsResponse response = null;

		// To load the userObject based on userId
		Optional<EmployeeRole> employeeRoleObj = employeeRoleRepository.findById(request.getId());

		if (employeeRoleObj.isPresent()) {

			// success
			response = new GetAssignmentsOptionsResponse(HttpStatus.OK, "000", "Get Assignments Success", null);
			response.setAssignments(role);
		} else {

			// failure
			response = new GetAssignmentsOptionsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "No Assignments",
					null);
		}

		return response;		
	}

	@Override
	public GetAssignmentsResponse getAssignments(GetAssignmentsRequest request) {
		GetAssignmentsResponse response = null;

		Optional<EmployeeRole> employeeRoleObj = employeeRoleRepository.findById(request.getRoleId());

		if (employeeRoleObj.isPresent()) {

			response = new GetAssignmentsResponse(HttpStatus.OK, "000", "fetch Address", null);

			response.setAssignments(role);

		} else {
			// failure
			response = new GetAssignmentsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "No Address found",
					null);

		}		return null;
	}

}
