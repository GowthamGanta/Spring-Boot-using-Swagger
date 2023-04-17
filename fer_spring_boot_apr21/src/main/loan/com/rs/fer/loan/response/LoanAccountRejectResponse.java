package com.rs.fer.loan.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.loan.entity.LoanAccount;
import com.rs.fer.response.AbstractResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanAccountRejectResponse extends AbstractResponse {

	public LoanAccountRejectResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;
	}

	
	private LoanAccount loanAccount;
}
