package com.rs.fer.expense.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.expense.entity.Expense;
import com.rs.fer.response.AbstractResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetExpenseOptionsResponse extends AbstractResponse {
	private Set<Expense> expenses;

	public GetExpenseOptionsResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;
	}
}
