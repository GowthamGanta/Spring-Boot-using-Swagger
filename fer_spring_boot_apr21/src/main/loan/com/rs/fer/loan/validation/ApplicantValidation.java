package com.rs.fer.loan.validation;

import java.util.Set;

import com.rs.fer.loan.request.LoanAccountApproveRequest;
import com.rs.fer.loan.request.LoanAccountRejectRequest;
import com.rs.fer.loan.request.SaveApplicantRequest;

public interface ApplicantValidation {

	Set<String> validateSaveApplicantRequest(SaveApplicantRequest request);

	Set<String> validateGetApplicantRequest(Integer applicantId);

	Set<String> loanAccountApproveRequest(LoanAccountApproveRequest request);

	Set<String> loanAccountRejectRequest(LoanAccountRejectRequest request);

	Set<String> validateGetLoanAccountRequest(int loanAccountId);
	
	Set<String> validateGetLoanAccountStatusRequest(String status);
}
