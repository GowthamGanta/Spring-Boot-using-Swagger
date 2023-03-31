package com.rs.fer.loan.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.loan.entity.Applicant;
import com.rs.fer.loan.repository.ApplicantRepository;
import com.rs.fer.loan.request.SaveApplicantRequest;
import com.rs.fer.loan.response.GetApplicantResponse;
import com.rs.fer.loan.response.SaveApplicantResponse;
import com.rs.fer.loan.service.ApplicantService;
import com.rs.fer.loan.util.ApplicantUtil;
import com.rs.fer.user.entity.User;
import com.rs.fer.user.response.GetUserResponse;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	ApplicantUtil applicantUtil;

	@Autowired
	ApplicantRepository applicantRepository;

	
	@Override
	public SaveApplicantResponse SaveApplicant(SaveApplicantRequest request) {
		

		SaveApplicantResponse response = null;

		// load vo to bean
		Applicant applicant = applicantUtil.loadSaveApplicantRequestToApplicant(request);

		// save bean to database
		applicant = applicantRepository.save(applicant);

		// load response
		if (applicant.getApplicantId() > 0) {
			// success
			response = new SaveApplicantResponse(HttpStatus.OK, "000", "Loan Application is saved successfully", null);
			response.setApplicant(applicant);
		} else {
			// failure
			response = new SaveApplicantResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Loan Application is failed",
					null);
		}

		return response;
		// return null;
	
	}


	@Override
	public GetApplicantResponse getApplicant(Integer applicantId) {

		GetApplicantResponse response = null;

		// To get the Applicant based on userId
		Optional<Applicant> applicantObj = applicantRepository.findById(applicantId);

		if (applicantObj.isPresent()) {
			// If Applicant is present
			response = new GetApplicantResponse(HttpStatus.OK, "000", "get Applicant is succesfull ", null);
			response.setApplicant(applicantObj.get());

		} else {
			// IfApplicant not present
			response = new GetApplicantResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "get Applicant is failed", null);

		}

		return response;
	}
}
