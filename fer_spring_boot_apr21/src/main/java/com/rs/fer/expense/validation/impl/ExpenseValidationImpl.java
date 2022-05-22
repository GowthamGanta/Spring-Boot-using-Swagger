package com.rs.fer.expense.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.request.EditExpenseRequest;
import com.rs.fer.expense.request.GetExpenseRequest;
import com.rs.fer.expense.request.GetExpensesRequest;
import com.rs.fer.expense.validation.ExpenseValidation;
import com.rs.fer.util.FERUtil;

@Component
public class ExpenseValidationImpl implements ExpenseValidation {

	@Override
	public Set<String> validateEditExpenseRequest(EditExpenseRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getExpenseId(), "Please enter expenseId");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getType(), "Please enter type");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getDate(), "Please enter date");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getPrice(), "Please enter price");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getNumberOfItems(),
				"Please enter numberOfItems");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getTotal(), "Please enter total");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getBywhom(), "Please enter bywhom");

		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteExpenseRequest(DeleteExpenseRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getExpenseid(), "Please select  expenseId");

		return errorMessages;
	}

	@Override
	public Set<String> validateAddExpenseRequest(AddExpenseRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUserId(), "Please enter UserId");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getType(), "Please enter Type");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getDate(), "Please enter Date");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getPrice(), "Please enter price");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getNumberOfItems(),
				"Please enter numberOfItems");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getTotal(), "Please enter total");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getBywhom(), "Please enter Mobile");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetExpenseRequest(GetExpenseRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getExpenseId(), "Please enter ExpenseId");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetExpensesRequest(GetExpensesRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUserId(), "Please enter UserId");

		return errorMessages;
	}

}
