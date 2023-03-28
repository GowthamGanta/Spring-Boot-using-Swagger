package com.rs.fer.loan.service;

import com.rs.fer.loan.request.SaveApplicantRequest;
import com.rs.fer.loan.response.ApplicantRegistrationResponse;

public interface ApplicantService {

	ApplicantRegistrationResponse registration(SaveApplicantRequest request);

}
