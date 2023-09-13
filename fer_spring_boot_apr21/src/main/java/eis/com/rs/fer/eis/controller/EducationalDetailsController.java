package com.rs.fer.eis.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.eis.request.EducationalDetailsRequest;
import com.rs.fer.eis.response.EducationalDetailsResponse;
import com.rs.fer.eis.service.EducationalDetailsService;
import com.rs.fer.eis.validation.EducationalDetailsValidation;

@RestController
@RequestMapping("/api")
public class EducationalDetailsController {
	@Autowired
	EducationalDetailsValidation educationalDetailsValidation;
	@Autowired
	EducationalDetailsService educationalDetailsService;

	@PostMapping("/saveEducationalDetails")
	public EducationalDetailsResponse addEducationalDetails(@RequestBody EducationalDetailsRequest request) {

		EducationalDetailsResponse response = null;

		Set<String> errorMessages = educationalDetailsValidation.validateSaveEducationalDetailsRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new EducationalDetailsResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = educationalDetailsService.saveEducationalDetails(request);
		}
		return response;
	}
}
