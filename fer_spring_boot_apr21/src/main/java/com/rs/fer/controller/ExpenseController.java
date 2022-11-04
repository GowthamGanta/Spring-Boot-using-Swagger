package com.rs.fer.controller;

import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.GetMapping;
>>>>>>> branch 'master' of https://github.com/GowthamGanta/Spring-Boot-using-Swagger.git
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
=======
import com.rs.fer.expense.request.GetExpenseRequest;
import com.rs.fer.expense.response.GetExpenseResponse;
>>>>>>> branch 'master' of https://github.com/GowthamGanta/Spring-Boot-using-Swagger.git
import com.rs.fer.expense.service.ExpenseService;
import com.rs.fer.expense.validation.ExpenseValidation;
import com.rs.fer.service.FERService;
import com.rs.fer.repository.ExpenseRepository;
import com.rs.fer.user.request.GetUserRequest;
import com.rs.fer.user.response.GetUserResponse;

@RestController
@RequestMapping("/api")
public class ExpenseController {

	@Autowired
	ExpenseValidation expenseValidation;
	
	@Autowired
	ExpenseService expenseService;
<<<<<<< HEAD
	
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
=======
>>>>>>> branch 'master' of https://github.com/GowthamGanta/Spring-Boot-using-Swagger.git
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteExpense(@PathVariable("id") int id) {
		try {
			expenseRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
<<<<<<< HEAD
	}		boolean isDeleteExpense = ferService.deleteExpense(id);
		if (isDeleteExpense) {
			return new ResponseEntity<>(id, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
=======
	}
	
	@GetMapping("/getExpense")
	public GetExpenseResponse getExpense(@RequestParam(value = "expenseId") GetExpenseRequest request) {

		GetExpenseResponse response = null;

		Set<String> errorMessages = expenseValidation.validateGetExpenseRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new GetExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = expenseService.getExpense(request);
		}
		return response;
	}
>>>>>>> branch 'master' of https://github.com/GowthamGanta/Spring-Boot-using-Swagger.git

		}

	}
	
}
