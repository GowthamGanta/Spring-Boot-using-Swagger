package com.rs.fer.loan.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.loan.entity.LoanAccount;
import com.rs.fer.response.AbstractResponse;

public class LoanAccountRejectResponse extends AbstractResponse {

	public LoanAccountRejectResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;
	}

	private LoanAccount loanAccount;

	public LoanAccount getLoanAccount() {
		return loanAccount;
	}

	public void setLoanAccount(LoanAccount loanAccount) {
		this.loanAccount = loanAccount;
	}

}
