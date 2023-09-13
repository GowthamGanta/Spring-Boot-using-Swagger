package com.rs.fer.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.eis.entity.EmployeeAddress;
import com.rs.fer.expense.entity.Expense;
import com.rs.fer.response.AbstractResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetEmployeeAddressResponse extends AbstractResponse {
	private EmployeeAddress employeeAddress;

	public GetEmployeeAddressResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;
	}

}
