package com.rs.fer.eis.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.eis.request.DeleteEmployeeSkillsRequest;
import com.rs.fer.eis.request.EditEmployeeSkillsRequest;
import com.rs.fer.eis.request.GetEmployeeSkillsOptionsRequest;
import com.rs.fer.eis.request.GetEmployeeSkillsRequest;
import com.rs.fer.eis.request.SaveEmployeeSkillsRequest;
import com.rs.fer.eis.response.DeleteEmployeeSkillsResponse;
import com.rs.fer.eis.response.EditEmployeeSkillsResponse;
import com.rs.fer.eis.response.GetEmployeeSkillsOptionsResponse;
import com.rs.fer.eis.response.GetEmployeeSkillsResponse;
import com.rs.fer.eis.response.SaveEmployeeSkillsResponse;
import com.rs.fer.eis.service.EmployeeSkillsService;
import com.rs.fer.eis.validation.EmployeeSkillsValidation;

@RestController
@RequestMapping("/api")
@Service
public class EmployeeSkillsController {
	@Autowired
	EmployeeSkillsValidation employeeSkillsValidation;
	@Autowired
	EmployeeSkillsService employeeSkillsService;

	@PostMapping("/saveEmployeeSkills")
	public SaveEmployeeSkillsResponse saveEmployeeSkills(@RequestBody SaveEmployeeSkillsRequest request) {

		SaveEmployeeSkillsResponse response = null;

		Set<String> errorMessages = employeeSkillsValidation.validateSaveEmployeeSkillsRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new SaveEmployeeSkillsResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = employeeSkillsService.saveEmployeeSkills(request);
		}
		return response;
	}

	@PutMapping("/editEmployeeSkills")
	public EditEmployeeSkillsResponse editEmployeeSkills(@RequestBody EditEmployeeSkillsRequest request) {

		EditEmployeeSkillsResponse response = null;

		Set<String> errorMessages = employeeSkillsValidation.validateEditEmployeeSkillsRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new EditEmployeeSkillsResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = employeeSkillsService.editEmployeeSkills(request);
		}
		return response;
	}

	@DeleteMapping("/deleteEmployeeSkills")
	public DeleteEmployeeSkillsResponse deleteEmployeeSkills(@RequestBody DeleteEmployeeSkillsRequest request) {

		DeleteEmployeeSkillsResponse response = null;

		Set<String> errorMessages = employeeSkillsValidation.validateDeleteEmployeeSkillsRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new DeleteEmployeeSkillsResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = employeeSkillsService.deleteEmployeeSkills(request);
		}
		return response;
	}

	@PostMapping("/getEmployeeSkillsOptions")
	public GetEmployeeSkillsOptionsResponse getEmployeeSkillsOptions(
			@RequestBody GetEmployeeSkillsOptionsRequest request) {

		GetEmployeeSkillsOptionsResponse response = null;

		Set<String> errorMessages = employeeSkillsValidation.validateGetEmployeeSkillsOptionsRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new GetEmployeeSkillsOptionsResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = employeeSkillsService.getEmployeeSkillsOptions(request);
		}
		return response;
	}

	@PostMapping("/getEmployeeSkills")
	public GetEmployeeSkillsResponse getEmployeeSkills(@RequestBody GetEmployeeSkillsRequest request) {

		GetEmployeeSkillsResponse response = null;

		Set<String> errorMessages = employeeSkillsValidation.validateGetEmployeeSkillsRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new GetEmployeeSkillsResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = employeeSkillsService.getEmployeeSkills(request);
		}
		return response;
	}

}
