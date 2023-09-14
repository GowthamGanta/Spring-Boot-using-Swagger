package com.rs.fer.eis.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PutMapping("/editAssignments")
	public EditAssignmentsResponse editAssignments(@RequestBody EditAssignmentsRequest request) {
		
		EditAssignmentsResponse response = null;
		
		Set<String> errorMessages = AssignmentsValidation.validateEditAssignmentsRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new EditAssignmentsResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		}else {
			response = AssignmentsService.editAssignments(request);
		}
		return response;
		
	}
	
	@DeleteMapping("/deleteAssignments")
	public DeleteAssignmentsResponse deleteAssignments(@ModelAttribute DeleteAssignmentsRequest request) {
		
		DeleteAssignmentsResponse response = null;
		
		Set<String> errorMessages = AssignmentsValidation.validateDeleteAssignmentsRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new DeleteAssignmentsResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		}else {
			response = AssignmentsService.deleteAssignments(request);
		}
		return response;
		
	}
	
	
	  @GetMapping("/getAssignmentsOptions") public GetAssignmentsOptionsResponse
	  getAssignmentsOptions(@RequestBody GetAssignmentsOptionsRequest request) {
	  
	  GetAssignmentsOptionsResponse response = null;
	  
	  Set<String> errorMessages =
	  AssignmentsValidation.validateGetAssignmentsOptionsRequest(request); 
	  //return response with error messages if
	  if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) { response
	  = new GetAssignmentsOptionsResponse(HttpStatus.PRECONDITION_FAILED, "999",
	  null, errorMessages);
	  
	  } else { response = AssignmentsService.getAssignmentsOptions(request); }
	  return response; }
	 
	
	@GetMapping("/getAssignments")
	public GetAssignmentsResponse getAssignments(@RequestBody GetAssignmentsRequest request) {

		GetAssignmentsResponse response = null;

		Set<String> errorMessages = AssignmentsValidation.validateGetAssignmentsRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new GetAssignmentsResponse(HttpStatus.PRECONDITION_FAILED, "999", null,
					errorMessages);

		} else {
			response = AssignmentsService.getAssignments(request);
		}
		return response;
	}


	
}
