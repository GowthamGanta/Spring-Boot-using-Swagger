package com.rs.fer.expense.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.rs.fer.expense.service.ExpenseService;
import com.rs.fer.expense.validation.ExpenseValidation;

@RestController
@RequestMapping("/api")
public class ExpenseController {
	@Autowired
	ExpenseValidation expenseValidation;
	@Autowired
	ExpenseService expenseService;

	@PostMapping("/addExpense")
	public AddExpenseResponse addExpense(@RequestBody AddExpenseRequest request) {

		AddExpenseResponse response = null;

		Set<String> errorMessages = expenseValidation.validateAddExpenseRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new AddExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = expenseService.addExpense(request);
		}
		return response;
	}

	@PostMapping("/getExpense")
	public GetExpenseResponse getExpense(@RequestBody GetExpenseRequest request) {

		GetExpenseResponse response = null;

		Set<String> errorMessages = expenseValidation.validateGetExpenseRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new GetExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = expenseService.getExpense(request);
		}
		return response;

	}

	@PostMapping("/expenseReport")
	public ExpenseReportResponse expenseReport(@RequestBody ExpenseReportRequest request) {

		ExpenseReportResponse response = null;

		Set<String> errorMessages = expenseValidation.validateExpenseReportRequest(request);

		/*
		 * List<Expense> expenseObj =
		 * expenseReportRepository.findByUserIdAndTypeAndDateBetween(request.getUserId()
		 * , request.getType(),request.getFromDate(),request.getToDate());
		 */

		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {

			response = new ExpenseReportResponse(HttpStatus.INTERNAL_SERVER_ERROR, "999", "No expense found", null);

		} else {
			response = expenseService.expenseReport(request);
		}
		return response;
	}

	@DeleteMapping("/deleteExpense")

	public DeleteExpenseResponse deleteExpense(@ModelAttribute DeleteExpenseRequest request) {

		DeleteExpenseResponse response = null;

		Set<String> errorMessages = expenseValidation.validateDeleteExpenseRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new DeleteExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = expenseService.deleteExpense(request);
		}
		return response;
	}

	@PutMapping("/editExpense")
	public EditExpenseResponse editExpense(@RequestBody EditExpenseRequest request) {

		EditExpenseResponse response = null;

		Set<String> errorMessages = expenseValidation.validateEditExpenseRequest(request);
		// return respnse with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new EditExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = expenseService.editExpense(request);
		}
		return response;

	}

	@PostMapping("/getExpenseOptions")
	public GetExpenseOptionsResponse getExpense(@RequestBody GetExpenseOptionsRequest request) {

		GetExpenseOptionsResponse response = null;

		Set<String> errorMessages = expenseValidation.validateGetExpenseOptionsRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new GetExpenseOptionsResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = expenseService.getExpenseOptions(request);
		}
		return response;
	}

}
