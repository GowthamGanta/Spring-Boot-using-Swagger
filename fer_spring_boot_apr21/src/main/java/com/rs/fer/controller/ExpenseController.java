package com.rs.fer.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.EditExpenseRequest;
import com.rs.fer.expense.request.GetExpensesRequest;
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

	@PostMapping("/addexpensema")
	public AddExpenseResponse addExpense(@ModelAttribute AddExpenseRequest request) {

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

	@PostMapping("/addExpense")
	public AddExpenseResponse addExpense1(@RequestBody AddExpenseRequest request) {
		AddExpenseResponse response = null;
		Set<String> errorMessages = expenseValidation.validateAddExpenseRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new AddExpenseResponse(HttpStatus.PRECONDITION_FAILED, "002", null, errorMessages);

		} else {
			response = expenseService.addExpense(request);
		}

		return response;
	}

	@PostMapping("/editExpense")
	public EditExpenseResponse editExpense(@RequestBody EditExpenseRequest request) {

		EditExpenseResponse response = null;
		Set<String> errorMessages = expenseValidation.validateEditExpenseRequest(request);

		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new EditExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = expenseService.editExpense(request);
		}

		return response;

	}

	@PostMapping("/userEditExpense")
	public EditExpenseResponse editExpense1(@ModelAttribute EditExpenseRequest request) {

		EditExpenseResponse response = null;

		Set<String> errorMessages = expenseValidation.validateEditExpenseRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new EditExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = expenseService.editExpense(request);
		}
		return response;
	}

	@PostMapping("/getExpenses")
	public GetExpensesResponse getExpenses(@RequestBody GetExpensesRequest request) {

		GetExpensesResponse response = null;

		Set<String> errorMessages = expenseValidation.validateGetExpensesRequest(request);

		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new GetExpensesResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = expenseService.getExpenses(request);
		}
		return response;
	}



	@PostMapping("/expenseReport")
	public ExpenseReportResponse expenseReport(@RequestBody ExpenseReportRequest request) {

		ExpenseReportResponse response = null;

		Set<String> errorMessages = expenseValidation.validateExpenseReportRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new ExpenseReportResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = expenseService.expenseReport(request);
		}
		return response;
	}
	
	@PostMapping("/getExpense")
	public GetExpenseResponse getExpenseRequest(@RequestBody GetExpenseRequest request) {
		GetExpenseResponse response=null;
		
		Set<String> errorMessages=expenseValidation.validateGetExpenseRequest(request);
		if(!CollectionUtils.isEmpty(errorMessages)) {
			response=new GetExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		}else {
			response=expenseService.getExpense(request);
		}
		return response;
	}
}
