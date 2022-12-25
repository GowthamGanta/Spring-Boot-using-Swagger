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
import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.request.EditExpenseRequest;
import com.rs.fer.expense.request.GetExpenseOptionsRequest;
import com.rs.fer.expense.request.GetExpenseRequest;
import com.rs.fer.expense.response.AddExpenseResponse;
import com.rs.fer.expense.response.DeleteExpenseResponse;
import com.rs.fer.expense.response.EditExpenseResponse;
import com.rs.fer.expense.response.GetExpenseOptionsResponse;
import com.rs.fer.expense.response.GetExpenseResponse;
import com.rs.fer.expense.service.ExpenseService;
import com.rs.fer.expense.validation.ExpenseValidation;

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
	@Test
	public void testgetExpense() {
		
		Set<String> errorMessages = new LinkedHashSet<>();
		
		GetExpenseRequest request = new GetExpenseRequest();
		GetExpenseResponse response = new GetExpenseResponse(HttpStatus.OK, "000", "", null);
		
		when(expenseValidation.validateGetExpenseRequest(Mockito.any())).thenReturn(errorMessages);
		when(expenseService.getExpense(Mockito.any())).thenReturn(response);
		
		GetExpenseResponse Response = expenseController.getExpense(request);

		assertEquals("000", response.statusCode);


	}

	@Test
	public void testGetExpenseFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter Type");

		GetExpenseRequest request = new GetExpenseRequest();  

		// When
		when(expenseValidation.validateGetExpenseRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		GetExpenseResponse response = expenseController.getExpense(request);

		assertEquals("999", response.statusCode);
	} 
	
	@Test
	public void testEditExpense() {

		Set<String> errorMessages = new LinkedHashSet<>();

		EditExpenseRequest request = new EditExpenseRequest();
		EditExpenseResponse response = new EditExpenseResponse(HttpStatus.OK, "000", "", null);

		when(expenseValidation.validateEditExpenseRequest(Mockito.any())).thenReturn(errorMessages);
		when(expenseService.editExpense(Mockito.any())).thenReturn(response);

		EditExpenseResponse Response = expenseController.editExpense(request);

		assertEquals("000", response.statusCode);

	}
	
	@Test
	public void testEditExpenseFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter Type");

		EditExpenseRequest request = new EditExpenseRequest();

		// When
		when(expenseValidation.validateEditExpenseRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		EditExpenseResponse response = expenseController.editExpense(request);

		assertEquals("999", response.statusCode);
	}

	@Test
	public void testGetExpenseOptions() {
		
		Set<String> errorMessages = new LinkedHashSet<>();
		
		GetExpenseOptionsRequest request = new GetExpenseOptionsRequest();
		GetExpenseOptionsResponse response = new GetExpenseOptionsResponse(HttpStatus.OK, "000", "", null);
		
		when(expenseValidation.validateGetExpenseOptionsRequest(Mockito.any())).thenReturn(errorMessages);
		when(expenseService.getExpenseOptions(Mockito.any())).thenReturn(response);
		
		GetExpenseOptionsResponse Response = expenseController.getExpense(request);

		assertEquals("000", response.statusCode);

    }
	
	@Test
	public void testGetExpenseOptionsFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter Type");

		GetExpenseOptionsRequest request = new GetExpenseOptionsRequest();  

		// When
		when(expenseValidation.validateGetExpenseOptionsRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		GetExpenseOptionsResponse response = expenseController.getExpense(request);

		assertEquals("999", response.statusCode);
	} 
	@Test
	public void testDeleteExpense() {
		
		Set<String> errorMessages = new LinkedHashSet<>();
		  
		DeleteExpenseRequest request = new DeleteExpenseRequest();
		DeleteExpenseResponse response = new DeleteExpenseResponse(HttpStatus.OK, "000", "", null);
		
		when(expenseValidation.validateGetExpenseRequest(Mockito.any())).thenReturn(errorMessages);
		when(expenseService.deleteExpense(Mockito.any())).thenReturn(response);
		
		DeleteExpenseResponse Response = expenseController.deleteExpense(request);

		assertEquals("000", response.statusCode);


	}  

	
	@Test
	public void testDeleteExpenseFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter Type");

		DeleteExpenseRequest request = new DeleteExpenseRequest();  

		// When
		when(expenseValidation.validateDeleteExpenseRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		DeleteExpenseResponse response = expenseController.deleteExpense(request);

		assertEquals("999", response.statusCode);
	}
	
}


