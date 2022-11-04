package com.rs.fer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.expense.service.ExpenseService;
import com.rs.fer.expense.validation.ExpenseValidation;
import com.rs.fer.service.FERService;
import com.rs.fer.repository.ExpenseRepository;

@RestController
@RequestMapping("/api")
public class ExpenseController {

	@Autowired
	ExpenseValidation expenseValidation;
	
	@Autowired
	ExpenseService expenseService;
	
	@Autowired
	private FERService ferService;
	
	@DeleteMapping("/deleteExpense/{expenseId}")
	public ResponseEntity<Integer> deleteExpenseMa(@RequestParam("expenseId") int id) {

		boolean isDeleteExpense = ferService.deleteExpense(id);
		if (isDeleteExpense) {
			return new ResponseEntity<>(id, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteExpense(@PathVariable("id") int id) {
		try {
			expenseRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}		boolean isDeleteExpense = ferService.deleteExpense(id);
		if (isDeleteExpense) {
			return new ResponseEntity<>(id, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	
}
