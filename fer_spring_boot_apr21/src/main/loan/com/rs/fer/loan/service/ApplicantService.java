package com.rs.fer.loan.service;

import com.rs.fer.loan.request.LoanAccountApproveRequest;
import com.rs.fer.loan.request.LoanAccountRejectRequest;
import com.rs.fer.loan.request.SaveApplicantRequest;
import com.rs.fer.loan.response.GetApplicantResponse;
import com.rs.fer.loan.response.GetLoanAccountResponse;
import com.rs.fer.loan.response.GetLoanAccountStatusResponse;
import com.rs.fer.loan.response.LoanAccountApproveResponse;
import com.rs.fer.loan.response.LoanAccountRejectResponse;
import com.rs.fer.loan.response.SaveApplicantResponse;

public interface ApplicantService {

	SaveApplicantResponse SaveApplicant(SaveApplicantRequest request);

	GetApplicantResponse getApplicant(Integer applicantId);

	LoanAccountApproveResponse LoanAccountApprove(LoanAccountApproveRequest request);

	LoanAccountRejectResponse LoanAccountReject(LoanAccountRejectRequest request);

	GetLoanAccountResponse getLoanAccount(int loanAccountId);
	
	GetLoanAccountStatusResponse getLoanAccountStatus(String status);
}
