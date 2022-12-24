package com.rs.fer.expense.validation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.expense.request.AddExpenseRequest;

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

}
