package com.rs.fer.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
//github.com/GowthamGanta/Spring-Boot-using-Swagger.git
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.request.GetExpenseRequest;
import com.rs.fer.expense.request.GetExpensesRequest;
import com.rs.fer.expense.response.DeleteExpenseResponse;
import com.rs.fer.expense.response.GetExpenseResponse;
//github.com/GowthamGanta/Spring-Boot-using-Swagger.git
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

	@GetMapping("/getExpensesReport")
	public GetExpensesResponse getExpensesReport(@ModelAttribute GetExpensesRequest request) {

		GetExpensesResponse response = null;

		Set<String> errorMessages = expenseValidation.validateGetExpensesRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new GetExpensesResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = expenseService.getExpenses(request);
		}
		return response;

	}
	
	@GetMapping("/getExpense" )

	public GetExpenseResponse getExpense(@ModelAttribute GetExpenseRequest request) {

		GetExpenseResponse response = null;
		Set<String> errorMessages = expenseValidation.validateGetExpenseRequest(request);

		// return response with error message
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

		// return response with error message
		if (!CollectionUtils.isEmpty(errorMessages)) {

			response = new DeleteExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {

			response = expenseService.deleteExpense(request);
		}

		return response;
	}
	
	@GetMapping("/getExpenseOptions")

	public GetExpensesResponse getExpenseOptions(@ModelAttribute GetExpensesRequest request) {
		GetExpensesResponse response = null;

		
		Set<String> errorMessages = expenseValidation.validateGetExpensesRequest(request);

		// return response with error message
		if (!CollectionUtils.isEmpty(errorMessages)) {

			response = new GetExpensesResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {

			response = expenseService.getExpenses(request);
		}

		return response;
	}
}