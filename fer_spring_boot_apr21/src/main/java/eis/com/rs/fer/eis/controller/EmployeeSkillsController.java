package com.rs.fer.eis.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.eis.request.SaveEmployeeSkillsRequest;
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

}
