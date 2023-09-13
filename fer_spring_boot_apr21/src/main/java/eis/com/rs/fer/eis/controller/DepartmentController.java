package com.rs.fer.eis.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.eis.request.AddDepartmentRequest;
import com.rs.fer.eis.response.AddDepartmentResponse;
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
}