package com.rs.fer.loan.validation;

import java.util.Set;

import com.rs.fer.loan.request.SaveApplicantRequest;

public interface ApplicantValidation {

	Set<String> validateSaveApplicantRequest(SaveApplicantRequest request);

}
