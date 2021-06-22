package com.rs.fer.expense.service;

import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.request.EditExpenseRequest;
import com.rs.fer.expense.request.GetExpenseRequest;
import com.rs.fer.expense.request.GetExpensesRequest;
import com.rs.fer.expense.response.AddExpenseResponse;
import com.rs.fer.expense.response.DeleteExpenseResponse;
import com.rs.fer.expense.response.EditExpenseResponse;
import com.rs.fer.expense.response.GetExpenseResponse;
import com.rs.fer.expense.response.GetExpensesResponse;

public interface ExpenseService {

	EditExpenseResponse editExpense(EditExpenseRequest request);

	DeleteExpenseResponse deleteExpense(DeleteExpenseRequest request);

	AddExpenseResponse addExpense(AddExpenseRequest request);

	GetExpenseResponse getExpense(GetExpenseRequest request);

	GetExpensesResponse getExpenses(GetExpensesRequest request);

}
