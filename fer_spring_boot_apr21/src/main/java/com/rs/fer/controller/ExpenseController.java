package com.rs.fer.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.expense.service.ExpenseService;
import com.rs.fer.expense.validation.ExpenseValidation;

@RestController
@RequestMapping("/api")
public class ExpenseController {

	@Autowired
	ExpenseValidation expenseValidation;
	@Autowired
	ExpenseService expenseService;
	@PostMapping("/registration")
	public ExpenseResponse registration(@RequestBody ExpenseRequest request) {

		ExpenseResponse response = null;

		Set<String> errorMessages = expenseValidation.validateexpenseRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new expenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);		
		} else {
			response = expenseService.registration(request);
		}
		return response;
	}
}
