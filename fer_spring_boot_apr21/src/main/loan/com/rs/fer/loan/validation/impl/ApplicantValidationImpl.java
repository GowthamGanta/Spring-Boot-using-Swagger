package com.rs.fer.loan.validation.impl;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.loan.request.SaveApplicantRequest;
import com.rs.fer.loan.validation.ApplicantValidation;

@Component
public class ApplicantValidationImpl implements ApplicantValidation {

	@Override
	public Set<String> validateRegistrationRequest(SaveApplicantRequest request) {
		return null;
	}

}
