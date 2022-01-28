package com.rs.fer.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	
	
	
}