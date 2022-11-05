  package com.rs.fer.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rs.fer.service.FERService;

@RestController
@RequestMapping("/api")
public class ExpenseController {
	@Autowired
	FERService ferService;
	
	@DeleteMapping("/deleteExpense/{expenseId}")
	public ResponseEntity<Integer> deleteExpenseMa(@PathVariable("expenseId") int id) {

		boolean isDeleteExpense = ferService.deleteExpense(id);
		if (isDeleteExpense) {
			return new ResponseEntity<>(id, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	
}
