package com.rs.fer.eis.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.eis.request.AddEmployeeRequest;
import com.rs.fer.eis.request.DeleteEmployeeRequest;
import com.rs.fer.eis.request.EditEmployeeRequest;
import com.rs.fer.eis.request.GetEmployeeRequest;
import com.rs.fer.eis.response.AddEmployeeResponse;
import com.rs.fer.eis.response.DeleteEmployeeResponse;
import com.rs.fer.eis.response.EditEmployeeResponse;
import com.rs.fer.eis.response.GetEmployeeResponse;
import com.rs.fer.eis.service.EmployeeService;
import com.rs.fer.eis.validation.EmployeeValidation;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeValidation employeeValidation;
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public AddEmployeeResponse addEmployee(@RequestBody AddEmployeeRequest request) {
		
		AddEmployeeResponse response = null;
		
		Set<String> errorMessages = employeeValidation.validateAddEmployeeRequest(request);
		
		if(!CollectionUtils.isEmpty(errorMessages)) {
			response = new AddEmployeeResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
			
		} else {
			response = employeeService.addEmployee(request);
		}
		return response;
		
	}
	
	@PutMapping("/editEmployee")
	public EditEmployeeResponse editEmployee(@RequestBody EditEmployeeRequest request) {
		
		EditEmployeeResponse response = null;
		
		Set<String> errorMessages = employeeValidation.validateEditEmployeeRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new EditEmployeeResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
			
		} else {
			response = employeeService.editEmployee(request);
		}
		return response;
	}
	
	@DeleteMapping("/deleteMapping")
	public DeleteEmployeeResponse deleteEmployee(@ModelAttribute DeleteEmployeeRequest request) {

		DeleteEmployeeResponse response = null;

		Set<String> errorMessages = employeeValidation.validateDeleteEmployeeRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new DeleteEmployeeResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = employeeService.deleteEmployee(request);
		}
		return response;
	}
	
	@PostMapping("/getEmployee")
	public GetEmployeeResponse getEmployee(@RequestBody GetEmployeeRequest request) {
		
		GetEmployeeResponse response = null;
		
		Set<String> errorMessages = employeeValidation.validateGetEmployeeRequest(request);
	
		// return response with error messages
		if(!CollectionUtils.isEmpty(errorMessages)) {
			response = new GetEmployeeResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = employeeService.getEmployee(request);
		}
		return response;
		
	}
}

