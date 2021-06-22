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

import com.rs.fer.expense.request.EditExpenseRequest;
import com.rs.fer.expense.request.GetExpenseRequest;
import com.rs.fer.expense.response.EditExpenseResponse;
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
	
}


