package com.rs.fer.loan.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.loan.request.LoanAccountApproveRequest;
import com.rs.fer.loan.request.LoanAccountRejectRequest;
import com.rs.fer.loan.request.SaveApplicantRequest;
import com.rs.fer.loan.response.GetApplicantResponse;
import com.rs.fer.loan.response.GetLoanAccountResponse;
import com.rs.fer.loan.response.GetLoanAccountStatusResponse;
import com.rs.fer.loan.response.LoanAccountApproveResponse;
import com.rs.fer.loan.response.LoanAccountRejectResponse;
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

		Set<String> errorMessages = applicantValidation.validateGetApplicantRequest(applicantId);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new GetApplicantResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = applicantService.getApplicant(applicantId);
		}
		return response;
	}

	@PutMapping("/LoanAccountApprove")
	public LoanAccountApproveResponse LoanAccountApprove(@RequestBody LoanAccountApproveRequest request) {

		LoanAccountApproveResponse response = null;

		Set<String> errorMessages = applicantValidation.loanAccountApproveRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new LoanAccountApproveResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = applicantService.LoanAccountApprove(request);
		}
		return response;
	}

	@PutMapping("/loan/LoanAccountReject")
	public LoanAccountRejectResponse LoanAccountReject(@RequestBody LoanAccountRejectRequest request) {

		LoanAccountRejectResponse response = null;

		Set<String> errorMessages = applicantValidation.loanAccountRejectRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new LoanAccountRejectResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = applicantService.LoanAccountReject(request);
		}
		return response;
	}

	@GetMapping("/loan/loanAccount/{loanAccountId}")

	public GetLoanAccountResponse getloanAccount(@PathVariable("loanAccountId") Integer loanAccountId) {

		GetLoanAccountResponse response = null; 

		Set<String> errorMessages = applicantValidation.validateGetloanAccountRequest(loanAccountId);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new GetLoanAccountResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = applicantService.getLoanAccount(loanAccountId);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/loan/{status}LoanAccount")
	public GetLoanAccountStatusResponse getLoanAccountByStatus(@PathVariable("status") String status) {
		GetLoanAccountStatusResponse response = null;

		Set<String> errorMessages = applicantValidation.validateGetLoanAccountStatusRequest(status);

		// return response with error messages

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new GetLoanAccountStatusResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = applicantService.getLoanAccountStatus(status);
		}
		return response;

	}

	
	
}
