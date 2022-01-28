package com.rs.fer.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.response.AddExpenseResponse;
import com.rs.fer.expense.response.DeleteExpenseResponse;
import com.rs.fer.expense.service.ExpenseService;
import com.rs.fer.expense.validation.ExpenseValidation;

@RestController
@RequestMapping("/api")
public class ExpenseController {

	@Autowired
	ExpenseValidation expenseValidation;
	@Autowired
	ExpenseService expenseService;

	@PostMapping("/ addExpense")

	public AddExpenseResponse AddExpense(@ModelAttribute AddExpenseRequest request) {

		AddExpenseResponse response = null;
		Set<String> errorMessages = expenseValidation.validateAddExpenseRequest(request);

		// return response with error message
		if (!CollectionUtils.isEmpty(errorMessages)) {

			response = new AddExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {

			response = expenseService.addExpense(request);
		}

		return response;
	}
	@DeleteMapping("/deleteExpense")

	public DeleteExpenseResponse deleteExpense(@PathVariable DeleteExpenseRequest request) {

		DeleteExpenseResponse response = null;
		Set<String> errorMessages = expenseValidation.validateDeleteExpenseRequest(request);

		// return response with error message
		if (!CollectionUtils.isEmpty(errorMessages)) {

			response = new DeleteExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {

			response = expenseService.deleteExpense(request);
		}

		return response;
	}


}