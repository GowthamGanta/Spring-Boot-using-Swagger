package com.rs.fer.expense.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.entity.Expense;
import com.rs.fer.response.AbstractResponse;

public class DeleteExpenseResponse extends AbstractResponse{

	private Expense expense;
	
	public DeleteExpenseResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;
	}

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}
	
	
}
