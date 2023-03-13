package com.rs.fer.expense.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.expense.entity.Expense;
import com.rs.fer.response.AbstractResponse;

public class ExpenseReportResponse extends AbstractResponse {

	private List<Expense> expense;

	public ExpenseReportResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;
	}

	public List<Expense> getExpense() {
		return expense;
	}

	public void setExpense(List<Expense> expense) {
		this.expense = expense;
	}

}
