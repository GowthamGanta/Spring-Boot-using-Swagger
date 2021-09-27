package com.rs.fer.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.expense.request.GetExpenseRequest;
import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.EditExpenseRequest;
import com.rs.fer.expense.request.GetExpensesRequest;
import com.rs.fer.expense.response.GetExpenseResponse;
import com.rs.fer.expense.response.AddExpenseResponse;
import com.rs.fer.expense.response.EditExpenseResponse;
import com.rs.fer.expense.response.GetExpensesResponse;
import com.rs.fer.expense.service.ExpenseService;
import com.rs.fer.expense.validation.ExpenseValidation;

@RestController
@RequestMapping("/api")
public class ExpenseController {

	@Autowired
	ExpenseValidation expenseValidation;

	@Autowired
	ExpenseService expenseService;

	@PostMapping("/addExpense2")
	public AddExpenseResponse addExpense2(@RequestBody AddExpenseRequest request) {

		AddExpenseResponse response = null;

		Set<String> errorMessages = expenseValidation.validateAddExpenseRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new AddExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = expenseService.addExpense(request);
		}
		return response;
	}

	@PostMapping("/editExpense2")
	public EditExpenseResponse editExpense2(@RequestBody EditExpenseRequest request) {

		EditExpenseResponse response = null;

		Set<String> errorMessages = expenseValidation.validateEditExpenseRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new EditExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = expenseService.editExpense(request);
		}

		return response;
	}

	@GetMapping("/getExpense")
	public GetExpenseResponse getExpenseById(@ModelAttribute GetExpenseRequest request) {

		GetExpenseResponse response = null;

		Set<String> errorMessages = expenseValidation.validateGetExpenseRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			// return response with error messages
			response = new GetExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = expenseService.getExpense(request);
		}
		return response;

	}

	@GetMapping("/getExpenses")
	public GetExpensesResponse getExpenses(@ModelAttribute GetExpensesRequest request) {

		GetExpensesResponse response = null;

		Set<String> errorMessages = expenseValidation.validateGetExpensesRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			// return response with error messages
			response = new GetExpensesResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = expenseService.getExpenses(request);
		}
		return response;

	}
	@GetMapping("/getExpenses2")
	public GetExpensesResponse getExpenses2(@ModelAttribute GetExpensesRequest request) {

		GetExpensesResponse response = null;

		Set<String> errorMessages = expenseValidation.validateGetExpensesRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			// return response with error messages
			response = new GetExpensesResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = expenseService.getExpenses(request);
		}
		return response;

	}

}