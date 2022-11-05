package com.rs.fer.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.entity.Expense;
import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.ExpenseReportRequest;
import com.rs.fer.expense.response.AddExpenseResponse;
import com.rs.fer.expense.response.ExpenseReportResponse;
import com.rs.fer.expense.service.ExpenseService;
import com.rs.fer.expense.validation.ExpenseValidation;
import com.rs.fer.repository.ExpenseRepository;

@RestController
@RequestMapping("/api")
public class ExpenseController {

	@Autowired
	ExpenseValidation expenseValidation;
	
	@Autowired
	ExpenseService expenseService;
	
	
	
	@PostMapping("/addExpense")
	public AddExpenseResponse addExpense(@RequestBody AddExpenseRequest request) {

		AddExpenseResponse response=null;
		
		Set<String> errorMessages =expenseValidation.validateAddExpenseRequest(request);
		//To show return response with error message.
		if(!CollectionUtils.isEmpty(errorMessages)) {
			response= new AddExpenseResponse(HttpStatus.PRECONDITION_FAILED,"999", null, errorMessages );
		}
		else {
			response=expenseService.addExpense(request);
			
		}
return response;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/expenseReport")
	public ExpenseReportResponse expenseReport(ExpenseReportRequest request) {
		ExpenseReportResponse response = null;

		List<Expense> expenseObj = ExpenseRepository.findByUserIdAndTypeAndDateBetween(request.getUserId(),
				request.getType(), request.getFromDate(), request.getToDate());
		if ((expenseObj) != null && !expenseObj.isEmpty()) {
			response = new ExpenseReportResponse(HttpStatus.OK, "000", "fetch expense", null);

		} else {
			response = new ExpenseReportResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Noexpensefound", null);
		}
		return response;
	}
}

	

