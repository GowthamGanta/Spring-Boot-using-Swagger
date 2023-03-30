package com.rs.fer.loan.service;

import com.rs.fer.loan.request.SaveApplicantRequest;
import com.rs.fer.loan.response.SaveApplicantResponse;

public interface ApplicantService {

	SaveApplicantResponse SaveApplicant(SaveApplicantRequest request);

}
