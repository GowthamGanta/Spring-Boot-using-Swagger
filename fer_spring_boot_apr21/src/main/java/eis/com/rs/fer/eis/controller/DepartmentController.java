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

import com.rs.fer.eis.request.AddDepartmentRequest;
import com.rs.fer.eis.request.DeleteDepartmentRequest;
import com.rs.fer.eis.request.EditDepartmentRequest;
import com.rs.fer.eis.request.GetDepartmentOptionsRequest;
import com.rs.fer.eis.request.GetDepartmentRequest;
import com.rs.fer.eis.response.AddDepartmentResponse;
import com.rs.fer.eis.response.DeleteDepartmentResponse;
import com.rs.fer.eis.response.EditDepartmentResponse;
import com.rs.fer.eis.response.GetDepartmentOptionsResponse;
import com.rs.fer.eis.response.GetDepartmentResponse;
import com.rs.fer.eis.service.DepartmentService;
import com.rs.fer.eis.validation.DepartmentValidation;

@RestController
@RequestMapping("/api")
public class DepartmentController {
	@Autowired
	DepartmentValidation departmentValidation;
	@Autowired
	DepartmentService departmentService;

	@PostMapping("/addDepartment")
	public AddDepartmentResponse addDepartment(@RequestBody AddDepartmentRequest request) {

		AddDepartmentResponse response = null;

		Set<String> errorMessages = departmentValidation.validateAddDepartmentRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new AddDepartmentResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = departmentService.addDepartment(request);
		}
		return response;
	}

	@PutMapping("/editDepartment")
	public EditDepartmentResponse editDepartment(@RequestBody EditDepartmentRequest request) {

		EditDepartmentResponse response = null;

		Set<String> errorMessages = departmentValidation.validateEditDepartmentRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new EditDepartmentResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = departmentService.editDepartment(request);
		}
		return response;
	}

	@DeleteMapping("/deleteDepartment")
	public DeleteDepartmentResponse deleteDepartment(@ModelAttribute DeleteDepartmentRequest request) {

		DeleteDepartmentResponse response = null;

		Set<String> errorMessages = departmentValidation.validateDeleteDepartmentRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new DeleteDepartmentResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = departmentService.deleteDepartment(request);
		}
		return response;
	}

	@GetMapping("/getDepartment")
	public GetDepartmentResponse getDepartment(@RequestBody GetDepartmentRequest request) {

		GetDepartmentResponse response = null;

		Set<String> errorMessages = departmentValidation.validateGetDepartmentRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new GetDepartmentResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = departmentService.getDepartment(request);
		}
		return response;
	}

	@GetMapping("/getDepartmentOptions")
	public GetDepartmentOptionsResponse getDepartmentOptions(@RequestBody GetDepartmentOptionsRequest request) {

		GetDepartmentOptionsResponse response = null;

		Set<String> errorMessages = departmentValidation.validateGetDepartmentOptionsRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new GetDepartmentOptionsResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = departmentService.getdepartmentOptions(request);
		}
		return response;
	}
}
