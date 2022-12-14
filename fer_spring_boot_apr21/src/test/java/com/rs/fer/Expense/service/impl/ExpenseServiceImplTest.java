package com.rs.fer.Expense.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.expense.entity.Expense;
import com.rs.fer.expense.repository.ExpenseRepository;
import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.response.DeleteExpenseResponse;
import com.rs.fer.expense.service.impl.ExpenseServiceImpl;

@SpringBootTest
public class ExpenseServiceImplTest {

	@InjectMocks
	private ExpenseServiceImpl expenseServiceImpl;

	@Mock
	ExpenseRepository expenseRepository;

	@Test
	public void testDeleteExpense() {

		Expense expense = new Expense();
		expense.setExpenseId(1);

		Optional<Expense> expenseObj = Optional.of(expense);

		// Mock
		when(expenseRepository.findById(Mockito.anyInt())).thenReturn(expenseObj);

		when(expenseRepository.save(Mockito.any())).thenReturn(expense);

		// 1.
		DeleteExpenseRequest request = new DeleteExpenseRequest();
		request.setExpenseid(1);

		// 2.
		DeleteExpenseResponse response = expenseServiceImpl.deleteExpense(request);

		// 3.
		assertEquals("000", response.statusCode);
	}

	@Test
	public void testDeleteExpenseNotPresent() {

		Optional<Expense> expenseObj = Optional.empty();

		// Mock
		when(expenseRepository.findById(Mockito.anyInt())).thenReturn(expenseObj);

		// 1.
		DeleteExpenseRequest request = new DeleteExpenseRequest();
		request.setExpenseid(1);

		// 2.
		DeleteExpenseResponse response = expenseServiceImpl.deleteExpense(request);

		// 3.
		assertEquals("002", response.statusCode);
	}

}
