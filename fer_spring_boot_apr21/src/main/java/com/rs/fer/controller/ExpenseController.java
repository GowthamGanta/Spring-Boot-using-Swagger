  package com.rs.fer.controller;



import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.entity.Expense;
import com.rs.fer.entity.User;
import com.rs.fer.expense.request.AddExpenseRequest;
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
	/*
	 * @DeleteMapping("/deleteExpense/{expenseId}") public ResponseEntity<Integer>
	 * deleteExpenseMa(@PathVariable("expenseId") int id) {
	 * 
	 * DeleteExpenseResponse response = null;
	 * 
	 * boolean isDeleteExpense = ferService.deleteExpense(id); if (isDeleteExpense)
	 * { return new ResponseEntity<>(id, HttpStatus.CREATED); } else { return new
	 * ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	 * 
	 * }
	 * 
	 * }
	 */
	
}
