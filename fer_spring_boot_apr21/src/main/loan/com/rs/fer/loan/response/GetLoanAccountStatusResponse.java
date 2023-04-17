package com.rs.fer.loan.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.loan.entity.Applicant;
import com.rs.fer.response.AbstractResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetLoanAccountStatusResponse extends AbstractResponse {

	public GetLoanAccountStatusResponse(HttpStatus status, String statusCode, String message,
			Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;

	}

	
	private Set<Applicant> loanAccounts;
}
