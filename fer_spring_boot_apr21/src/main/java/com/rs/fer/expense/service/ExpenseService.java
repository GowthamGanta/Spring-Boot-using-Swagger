package com.rs.fer.expense.service;

import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.request.EditExpenseRequest;
import com.rs.fer.expense.request.ExpenseReportRequest;
import com.rs.fer.expense.request.GetExpenseOptionsRequest;
import com.rs.fer.expense.request.GetExpenseRequest;
import com.rs.fer.expense.response.AddExpenseResponse;
import com.rs.fer.expense.response.DeleteExpenseResponse;
import com.rs.fer.expense.response.EditExpenseResponse;
import com.rs.fer.expense.response.ExpenseReportResponse;
import com.rs.fer.expense.response.GetExpenseOptionsResponse;
import com.rs.fer.expense.response.GetExpenseResponse;


public interface ExpenseService {

	static EditExpenseResponse editExpense(EditExpenseRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	DeleteExpenseResponse deleteExpense(DeleteExpenseRequest request);

	AddExpenseResponse addExpense(AddExpenseRequest request);

	GetExpenseResponse getExpense(GetExpenseRequest request);

	GetExpenseOptionsResponse getExpenseOptions(GetExpenseOptionsRequest request);

	ExpenseReportResponse expenseReport(ExpenseReportRequest request);
	
}
