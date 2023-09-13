package com.rs.fer.eis.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.eis.request.AddAssignmentsRequest;
import com.rs.fer.eis.response.AddAssignmentsResponse;
import com.rs.fer.eis.service.AssignmentsService;
import com.rs.fer.eis.validation.AssignmentsValidation;


@RestController
@RequestMapping("/api")
public class EmployeeRoleAssignmentsController {
	@Autowired
	AssignmentsValidation AssignmentsValidation;
	@Autowired
	AssignmentsService AssignmentsService;
	/*@Autowired
	EmployeeRoleValidation EmployeeRoleValidation;
	@Autowired
	EmployeeRoleService EmployeeRoleService;*/
	
	@PostMapping("/addAssignments")
	public AddAssignmentsResponse addAssignments(@RequestBody AddAssignmentsRequest request) {
		
		AddAssignmentsResponse response = null;
		
		Set<String> errorMessages = AssignmentsValidation.validateAddAssignmentsRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new AddAssignmentsResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		}else {
			response = AssignmentsService.addAssignments(request);
		}
		return response;
		
	}
	
}
