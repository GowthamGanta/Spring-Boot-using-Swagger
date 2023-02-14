package com.rs.fer.expense.validation.impl;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks; 

import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.request.EditExpenseRequest;
import com.rs.fer.expense.request.ExpenseReportRequest;
import com.rs.fer.expense.request.GetExpenseOptionsRequest;
import com.rs.fer.expense.request.GetExpenseRequest;

@SpringBootTest

public class ExpenseValidationImplTest {

	@InjectMocks
	private ExpenseValidationImpl expenseValidationImpl;

	@Test
	public void testvalidateAddExpenseRequest() {

		AddExpenseRequest request = new AddExpenseRequest();

		request.setUserId(1);
		request.setType("chocolate");
		request.setDate("24/12/22");
		request.setPrice(150);
		request.setNumberOfItems(2);
		request.setTotal(300);
		request.setBywhom("me");

		Set<String> errorMessages = expenseValidationImpl.validateAddExpenseRequest(request);

		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test

	public void testvalidateAddExpenseRequestFailure() {

		AddExpenseRequest request = new AddExpenseRequest();

		request.setUserId(1);
		// request.setType("chocolate");
		request.setDate("24/12/22");  
		request.setPrice(150);
		request.setNumberOfItems(2);
		request.setTotal(300);
		request.setBywhom("me");
  
		Set<String> errorMessages = expenseValidationImpl.validateAddExpenseRequest(request);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}
	
	
	@Test
	public void testvalidateGetExpenseRequest() {
		
		GetExpenseRequest request = new GetExpenseRequest();
		
		request.setExpenseId(1);  
		
		Set<String> errorMessages = expenseValidationImpl.validateGetExpenseRequest(request);
		
		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

		
	}  
	

	@Test

	public void testvalidateGetExpenseRequestFailure() {

	GetExpenseRequest request = new GetExpenseRequest();
	
	request.setExpenseId(0);
	
	
	Set<String> errorMessages = expenseValidationImpl.validateGetExpenseRequest(request);
	
	boolean isExpectedEmpty = false;
	boolean isActualEmpty = errorMessages.isEmpty();
	
	assertEquals(isExpectedEmpty, isActualEmpty);  
	  
	
	}
	
	@Test
	public void testvalidateEditExpenseRequest() {

		EditExpenseRequest request = new EditExpenseRequest();
        request.setExpenseId(1);
		request.setType("tea");
		request.setDate("24/12/22");
		request.setPrice(150);
		request.setNumberOfItems(2);
		request.setTotal(300);
		request.setBywhom("me");

		Set<String> errorMessages = expenseValidationImpl.validateEditExpenseRequest(request);

		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}
	
	@Test

	public void testvalidateEditExpenseRequestFailure() {

		EditExpenseRequest request = new EditExpenseRequest();
        request.setExpenseId(1);
		request.setType("tea");
		//request.setDate("24/12/22");
		request.setPrice(150);
		request.setNumberOfItems(2);
		request.setTotal(300);
		request.setBywhom("me");

		Set<String> errorMessages = expenseValidationImpl.validateEditExpenseRequest(request);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	} 
	
	@Test
	public void testvalidateGetExpenseOptionsRequest() {
		
		GetExpenseOptionsRequest request = new GetExpenseOptionsRequest();
		
		request.setUserId(1);
		
		Set<String> errorMessages = expenseValidationImpl.validateGetExpenseOptionsRequest(request);
		
		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);	
	}  
	
	@Test

	public void testvalidateGetExpenseOptionsRequestFailure() {

	GetExpenseOptionsRequest request = new GetExpenseOptionsRequest();
	
	request.setUserId(0);
	
	
	Set<String> errorMessages = expenseValidationImpl.validateGetExpenseOptionsRequest(request);
	
	boolean isExpectedEmpty = false;
	boolean isActualEmpty = errorMessages.isEmpty();
	
	assertEquals(isExpectedEmpty, isActualEmpty);  
	  
	
	}
	
	@Test
	public void testvalidateDeleteExpenseRequest() {

		DeleteExpenseRequest request = new DeleteExpenseRequest();

		request.setExpenseid(1);

		Set<String> errorMessages = expenseValidationImpl.validateDeleteExpenseRequest(request);

		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}

	@Test 

	public void testvalidateDeleteExpenseFailure() {

		GetExpenseRequest request = new GetExpenseRequest();

		request.setExpenseId(0);

		Set<String> errorMessages = expenseValidationImpl.validateGetExpenseRequest(request);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}
	
	@Test
	public void testvalidateExpenseReportRequest() {

		ExpenseReportRequest request = new ExpenseReportRequest();

		request.setUserId(1);
		request.setType("chocolate");
		request.setFromDate("28-01-2022");
		request.setToDate("30-01-2022");

		Set<String> errorMessages = expenseValidationImpl.validateExpenseReportRequest(request);

		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}
	
	@Test
	public void testvalidateExpenseReportRequestFailure() {

		ExpenseReportRequest request = new ExpenseReportRequest();

		request.setUserId(1);
		//request.setType("chocolate");
		request.setFromDate("28-01-2022");
		request.setToDate("30-01-2022");

		Set<String> errorMessages = expenseValidationImpl.validateExpenseReportRequest(request);

		boolean isExpectedEmpty = false;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}
}
