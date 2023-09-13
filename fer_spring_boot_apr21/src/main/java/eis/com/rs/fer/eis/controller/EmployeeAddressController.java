package com.rs.fer.eis.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.eis.request.AddEmployeeAddressRequest;
import com.rs.fer.eis.response.AddEmployeeAddressResponse;
import com.rs.fer.eis.service.EmployeeService;
import com.rs.fer.eis.service.EmployeeAddressService;
import com.rs.fer.eis.validation.EmployeeValidation;
import com.rs.fer.eis.validation.EmployeeAddressValidation;

@RestController
@RequestMapping("/api")
public class EmployeeAddressController {

	@Autowired
	EmployeeValidation addEmployeeValidation;

	@Autowired
	EmployeeService addEmployeeService;

	@Autowired
	EmployeeAddressService employeeAddressService;

	@Autowired
	EmployeeAddressValidation employeeAddressValidation;

	@PostMapping("/addEmployeeAddress")
	public AddEmployeeAddressResponse addEmployeeAddress(@RequestBody AddEmployeeAddressRequest request) {

		AddEmployeeAddressResponse response = null;
		Set<String> errorMessages = employeeAddressValidation.validateAddEmployeeAddressRequest(request);

		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new AddEmployeeAddressResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = employeeAddressService.addEmployee(request);
		}
		return response;
	}

}
