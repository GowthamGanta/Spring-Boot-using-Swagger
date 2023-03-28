package com.rs.fer.loan.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.loan.request.SaveApplicantRequest;
import com.rs.fer.loan.response.ApplicantRegistrationResponse;
import com.rs.fer.loan.service.ApplicantService;
import com.rs.fer.loan.validation.ApplicantValidation;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.response.RegistrationResponse;

@RestController
@RequestMapping("/api")
public class ApplicantController {

	@Autowired
	ApplicantValidation applicantValidation;

	@Autowired
	ApplicantService applicantService;

	@PostMapping("/loan/registration")
	public ApplicantRegistrationResponse registration(@RequestBody SaveApplicantRequest request) {

		ApplicantRegistrationResponse response = null;

		Set<String> errorMessages = applicantValidation.validateRegistrationRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new ApplicantRegistrationResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = applicantService.registration(request);
		}

		return response;

	}
	

}
