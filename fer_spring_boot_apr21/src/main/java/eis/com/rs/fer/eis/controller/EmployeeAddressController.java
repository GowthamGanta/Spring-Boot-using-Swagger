package com.rs.fer.eis.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.eis.request.AddEmployeeAddressRequest;
import com.rs.fer.eis.request.DeleteEmployeeAddressRequest;
import com.rs.fer.eis.request.EditEmployeeAddressRequest;
import com.rs.fer.eis.request.GetEmployeeAddressOptionsRequest;
import com.rs.fer.eis.request.GetEmployeeAddressRequest;
import com.rs.fer.eis.response.AddEmployeeAddressResponse;
import com.rs.fer.eis.response.DeleteEmployeeAddressResponse;
import com.rs.fer.eis.response.EditEmployeeAddressResponse;
import com.rs.fer.eis.response.GetEmployeeAddressOptionsResponse;
import com.rs.fer.eis.response.GetEmployeeAddressResponse;
import com.rs.fer.eis.service.EmployeeAddressService;
import com.rs.fer.eis.validation.EmployeeAddressValidation;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EmployeeAddressController {

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
			response = employeeAddressService.addEmployeeAddress(request);
		}
		return response;
	}

	@PutMapping("/editEmployeeAddress")
	public EditEmployeeAddressResponse editEmployeeAddress(@RequestBody EditEmployeeAddressRequest request) {

		EditEmployeeAddressResponse response = null;
		Set<String> errorMessages = employeeAddressValidation.validateEditEmployeeAddressRequest(request);

		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new EditEmployeeAddressResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = employeeAddressService.editEmployeeAddress(request);
		}
		return response;

	}

	@PostMapping("/getEmployeeAddressOptions")
	public GetEmployeeAddressOptionsResponse getEmployeeAddress(@ModelAttribute GetEmployeeAddressOptionsRequest request) {

		GetEmployeeAddressOptionsResponse response = null;

		Set<String> errorMessages = employeeAddressValidation.validateGetEmployeeAddressOptionsRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new GetEmployeeAddressOptionsResponse(HttpStatus.PRECONDITION_FAILED, "999", null,
					errorMessages);

		} else {
			response = employeeAddressService.getEmployeeAddressOptions(request);
		}
		return response;
	}

	@DeleteMapping("/deleteEmployeeAddress")

	public DeleteEmployeeAddressResponse deleteEmployeeAddress(@ModelAttribute DeleteEmployeeAddressRequest request) {

		DeleteEmployeeAddressResponse response = null;

		Set<String> errorMessages = employeeAddressValidation.validateDeleteEmployeeAddressRequest(request);

		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new DeleteEmployeeAddressResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = employeeAddressService.deleteEmployeeAddress(request);
		}
		return response;
	}

	@PostMapping("/getEmployeeAddress")
	public GetEmployeeAddressResponse getEmployeeAddress(@ModelAttribute GetEmployeeAddressRequest request) {

		GetEmployeeAddressResponse response = null;

		Set<String> errorMessages = employeeAddressValidation.validateGetEmployeeAddressRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new GetEmployeeAddressResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = employeeAddressService.getEmployeeAddress(request);
		}
		return response;

	}
}
