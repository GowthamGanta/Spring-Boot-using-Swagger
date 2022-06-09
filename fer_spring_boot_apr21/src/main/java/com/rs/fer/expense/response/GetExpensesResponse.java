package com.rs.fer.expense.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.entity.Expense;
import com.rs.fer.response.AbstractResponse;

public class GetExpensesResponse extends AbstractResponse {

	private Set<Expense> expenses;

	public GetExpensesResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;
	}

	public Set<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}
}
