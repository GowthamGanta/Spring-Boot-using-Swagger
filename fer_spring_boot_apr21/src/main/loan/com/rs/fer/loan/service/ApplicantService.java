package com.rs.fer.loan.service;

import com.rs.fer.loan.request.LoanAccountApproveRequest;
import com.rs.fer.loan.request.LoanAccountRejectRequest;
import com.rs.fer.loan.request.SaveApplicantRequest;
import com.rs.fer.loan.response.GetApplicantResponse;
import com.rs.fer.loan.response.LoanAccountApproveResponse;
import com.rs.fer.loan.response.LoanAccountRejectResponse;
import com.rs.fer.loan.response.SaveApplicantResponse;

public interface ApplicantService {

	SaveApplicantResponse SaveApplicant(SaveApplicantRequest request);

	GetApplicantResponse getApplicant(Integer applicantId);

	LoanAccountApproveResponse LoanAccount(LoanAccountApproveRequest request);

	LoanAccountRejectResponse LoanAccount(LoanAccountRejectRequest request);
}
