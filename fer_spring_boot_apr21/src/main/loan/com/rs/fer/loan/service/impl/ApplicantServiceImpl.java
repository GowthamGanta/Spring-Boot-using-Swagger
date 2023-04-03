package com.rs.fer.loan.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.loan.entity.Applicant;
import com.rs.fer.loan.entity.LoanAccount;
import com.rs.fer.loan.repository.ApplicantRepository;
import com.rs.fer.loan.repository.LoanAccountRepository;
import com.rs.fer.loan.request.LoanAccountApproveRequest;
import com.rs.fer.loan.request.LoanAccountRejectRequest;
import com.rs.fer.loan.request.SaveApplicantRequest;
import com.rs.fer.loan.response.GetApplicantResponse;
import com.rs.fer.loan.response.GetLoanAccountResponse;
import com.rs.fer.loan.response.LoanAccountApproveResponse;
import com.rs.fer.loan.response.LoanAccountRejectResponse;
import com.rs.fer.loan.response.SaveApplicantResponse;
import com.rs.fer.loan.service.ApplicantService;
import com.rs.fer.loan.util.ApplicantUtil;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	ApplicantUtil applicantUtil;

	@Autowired
	ApplicantRepository applicantRepository;

	@Autowired
	LoanAccountRepository loanAccountRepository;

	@Override
	public SaveApplicantResponse SaveApplicant(SaveApplicantRequest request) {

		SaveApplicantResponse response = null;

		// load vo to bean
		LoanAccount loanAccount = applicantUtil.loadSaveApplicantRequestToApplicant(request);

		// save bean to database
		loanAccount = loanAccountRepository.save(loanAccount);

		// load response
		if (loanAccount.getLoanAccountId() > 0) {
			// success
			response = new SaveApplicantResponse(HttpStatus.OK, "000", "Loan Application is saved successfully", null);
			response.setLoanAccount(loanAccount);
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
			response = new GetApplicantResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "get Applicant is failed",
					null);

		}

		return response;
	}

	@Override
	public LoanAccountApproveResponse LoanAccount(LoanAccountApproveRequest request) {

		LoanAccountApproveResponse response = null;

		Optional<LoanAccount> loanAccounts = loanAccountRepository.findById(request.getLoanAccountId());

		if (loanAccounts.isPresent()) {
			LoanAccount loanAccount = loanAccounts.get();
			if (loanAccount.getStatus().equals(request.getStatus())) {
				// success
				loanAccount.setStatus("A");
				loanAccountRepository.save(loanAccount);
				response = new LoanAccountApproveResponse(HttpStatus.OK, "000", "LoanAccount Approved successfully",
						null);
			} else {
				// failure

				response = new LoanAccountApproveResponse(HttpStatus.INTERNAL_SERVER_ERROR, "102",
						"Id and Status which is on the account are not matching", null);

			}
		} else {
			response = new LoanAccountApproveResponse(HttpStatus.PRECONDITION_FAILED, "101", "LoanAccount is not found",
					null);

		}

		return response;

	}

	@Override
	public LoanAccountRejectResponse LoanAccount(LoanAccountRejectRequest request) {

		LoanAccountRejectResponse response = null;

		Optional<LoanAccount> loanAccounts = loanAccountRepository.findById(request.getLoanAccountId());

		if (loanAccounts.isPresent()) {
			LoanAccount loanAccount = loanAccounts.get();
			if (loanAccount.getStatus().equals(request.getStatus())) {
				// success
				loanAccount.setStatus("R");
				loanAccountRepository.save(loanAccount);
				response = new LoanAccountRejectResponse(HttpStatus.OK, "000", "LoanAccount Rejected", null);
			} else {
				// failure

				response = new LoanAccountRejectResponse(HttpStatus.INTERNAL_SERVER_ERROR, "102",
						"Id and Status which is on the account are not matching", null);

			}
		} else {
			response = new LoanAccountRejectResponse(HttpStatus.PRECONDITION_FAILED, "101", "LoanAccount is not found",
					null);

		}

		return response;

	}

	@Override
	public GetLoanAccountResponse getLoanAccount(int loanAccountId) {

		GetLoanAccountResponse response = null;

		// To get the Applicant based on userId
		Optional<LoanAccount> loanAccounts = loanAccountRepository.findById(loanAccountId);

		if (loanAccounts.isPresent()) {
			// If Applicant is present
			response = new GetLoanAccountResponse(HttpStatus.OK, "000", "get loanAccount list ", null);
			response.setLoanAccount(loanAccounts.get());

		} else {
			// IfApplicant not present
			response = new GetLoanAccountResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "get loanAccount is failed",
					null);

		}

		return response;
	}

}
