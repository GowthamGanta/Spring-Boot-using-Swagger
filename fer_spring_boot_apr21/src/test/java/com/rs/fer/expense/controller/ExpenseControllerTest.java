package com.rs.fer.expense.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.response.AddExpenseResponse;
import com.rs.fer.expense.service.ExpenseService;
import com.rs.fer.expense.validation.ExpenseValidation;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.response.RegistrationResponse;
import com.rs.fer.user.service.UserService;
import com.rs.fer.user.validation.UserValidation;

@SpringBootTest
public class ExpenseControllerTest {

	@InjectMocks
	private ExpenseController expenseController;

	@Mock
	ExpenseValidation expenseValidation;

	@Mock
	ExpenseService expenseService;

	@Test
	public void testAddExpense() {

		Set<String> errorMessages = new LinkedHashSet<>();

		AddExpenseRequest request = new AddExpenseRequest();
		AddExpenseResponse response = new AddExpenseResponse(HttpStatus.OK, "000", "", null);

		when(expenseValidation.validateAddExpenseRequest(Mockito.any())).thenReturn(errorMessages);
		when(expenseService.addExpense(Mockito.any())).thenReturn(response);

		AddExpenseResponse regResponse = expenseController.addExpense(request);

		assertEquals("000", response.statusCode);

	}

	@Test
	public void testAddExpenseFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter Type");

		AddExpenseRequest request = new AddExpenseRequest();

		// When
		when(expenseValidation.validateAddExpenseRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		AddExpenseResponse response = expenseController.addExpense(request);

		assertEquals("999", response.statusCode);
	}
}
