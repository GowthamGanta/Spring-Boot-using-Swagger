package com.rs.fer.expense.validation;

import java.util.Set;

import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.request.EditExpenseRequest;
import com.rs.fer.expense.request.ExpenseReportRequest;
import com.rs.fer.expense.request.GetExpenseRequest;
import com.rs.fer.expense.request.GetExpensesRequest;

public interface ExpenseValidation {

	Set<String> validateAddExpenseRequest(AddExpenseRequest request);

	Set<String> validateEditExpenseRequest(EditExpenseRequest request);

	Set<String> validateDeleteExpenseRequest(DeleteExpenseRequest request);

	Set<String> validateGetExpenseRequest(GetExpenseRequest request);

	 Set<String> validateGetExpensesRequest(GetExpensesRequest request);

	Set<String> validateExpenseReportRequest(ExpenseReportRequest request);
	 
			
}
