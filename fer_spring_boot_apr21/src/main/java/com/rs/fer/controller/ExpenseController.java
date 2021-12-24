package com.rs.fer.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.request.GetExpenseRequest;
import com.rs.fer.expense.request.GetExpensesRequest;
import com.rs.fer.expense.response.AddExpenseResponse;
import com.rs.fer.expense.response.DeleteExpenseResponse;
import com.rs.fer.expense.response.GetExpenseResponse;
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

	
	@PostMapping("/addexpense")
	public  AddExpenseResponse addExpense(@ModelAttribute AddExpenseRequest request) {


		AddExpenseResponse response = null;

		Set<String> errorMessages = expenseValidation.validateAddExpenseRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new AddExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = expenseService.addExpense(request);
		}
		return response;
	}
	
	
	@GetMapping("/getExpense")
	public GetExpenseResponse getExpenseById(@ModelAttribute GetExpenseRequest request) {

		GetExpenseResponse response = null;

		Set<String> errorMessages = expenseValidation.validateGetExpenseRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new GetExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = expenseService.getExpense(request);
		}
		return response;
	}
	@DeleteMapping("/deleteExpense")
	public DeleteExpenseResponse deleteExpense(@RequestBody DeleteExpenseRequest request) {

		DeleteExpenseResponse response = null;

		Set<String> errorMessages = expenseValidation.validateDeleteExpenseRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new DeleteExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = expenseService.deleteExpense(request);
		}

		return response;
	}
	
	@GetMapping("/getExpenseOptions")
	public GetExpenseResponse getExpenseOptions(@ModelAttribute GetExpenseRequest request) {

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
	@GetMapping("/getExpensesReport")
	public GetExpensesResponse getExpensesReport(@ModelAttribute GetExpensesRequest request) {

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