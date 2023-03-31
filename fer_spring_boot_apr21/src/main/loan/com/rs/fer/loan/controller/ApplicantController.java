package com.rs.fer.loan.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.loan.request.SaveApplicantRequest;
import com.rs.fer.loan.response.GetApplicantResponse;
import com.rs.fer.loan.response.SaveApplicantResponse;
import com.rs.fer.loan.service.ApplicantService;
import com.rs.fer.loan.validation.ApplicantValidation;

@RestController
@RequestMapping("/api")
public class ApplicantController {

	@Autowired
	ApplicantValidation applicantValidation;

	@Autowired
	ApplicantService applicantService;

	@PostMapping("/loan/saveApplicant")
	public SaveApplicantResponse SaveApplicant(@RequestBody SaveApplicantRequest request) {

		SaveApplicantResponse response = null;

		Set<String> errorMessages = applicantValidation.validateSaveApplicantRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new SaveApplicantResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = applicantService.SaveApplicant(request);
		}

		return response;

	}
	
	@GetMapping("/loan/getApplicant/{applicantId}")
	
	public GetApplicantResponse getApplicant(@PathVariable("applicantId") Integer applicantId) {

		GetApplicantResponse response = null;

		Set<String> errorMessages = applicantValidation.validateGetapplicantRequest(applicantId);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new GetApplicantResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = applicantService.getApplicant(applicantId);
		}
		return response;
	}

}
