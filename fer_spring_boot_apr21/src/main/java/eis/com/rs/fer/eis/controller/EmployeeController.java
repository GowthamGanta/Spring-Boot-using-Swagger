package com.rs.fer.eis.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.eis.request.AddEmployeeRequest;
import com.rs.fer.eis.response.AddEmployeeResponse;
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
}
