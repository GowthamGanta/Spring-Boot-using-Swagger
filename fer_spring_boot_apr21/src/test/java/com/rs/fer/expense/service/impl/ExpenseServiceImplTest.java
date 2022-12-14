package com.rs.fer.expense.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedHashSet;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.expense.entity.Expense;
import com.rs.fer.expense.repository.ExpenseRepository;
import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.request.GetExpenseOptionsRequest;
import com.rs.fer.expense.response.AddExpenseResponse;
import com.rs.fer.expense.response.DeleteExpenseResponse;
import com.rs.fer.expense.response.GetExpenseOptionsResponse;
import com.rs.fer.expense.util.ExpenseUtil;
import com.rs.fer.user.entity.User;
import com.rs.fer.user.repository.UserRepository;

@SpringBootTest
public class ExpenseServiceImplTest {
 
	@InjectMocks
	private ExpenseServiceImpl expenseServiceImpl;

	@Mock
	ExpenseRepository expenseRepository;
	@Mock
	ExpenseUtil expenseUtil;

	@Mock
	UserRepository userRepository;

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

	@Test
	public void testAddExpense() {

		Expense expense = new Expense();
		User user = new User();

		user.setUserId(1);

		user.setExpenses(new LinkedHashSet<Expense>());

		Optional<User> userObj = Optional.of(user);

		// User user = userObj.get();

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(expenseUtil.loadAddExpenseRequestToExpense(Mockito.any())).thenReturn(expense);

		when(userRepository.save(Mockito.any())).thenReturn(user);

		AddExpenseRequest request = new AddExpenseRequest();
		request.setType("tea");
		request.setDate("13/12/22");
		request.setPrice(120);
		request.setNumberOfItems(2);
		request.setTotal(240);
		request.setBywhom("me");
		request.setUserId(1);

		// 2.
		AddExpenseResponse response = expenseServiceImpl.addExpense(request);

		// 3.
		assertEquals("000", response.statusCode);

	}

	@Test
	public void testAddExpenseIdIsNotPresent() {

		Optional<User> userObj = Optional.empty();

		// Expense expense = new Expense();
		// User user = null;

		Expense expense = null;
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		// when(userRepository.save(Mockito.any())).thenReturn(userObj);

		when(expenseUtil.loadAddExpenseRequestToExpense(Mockito.any())).thenReturn(expense);

		// 1.
		AddExpenseRequest request = new AddExpenseRequest();
		request.setType("tea");
		request.setDate("13/12/22");
		request.setPrice(120);
		request.setNumberOfItems(2);
		request.setTotal(240);
		request.setBywhom("me");
		request.setUserId(1);

		// 2.
		AddExpenseResponse response = expenseServiceImpl.addExpense(request);

		// 3.
		assertEquals("002", response.statusCode);
	}

	@Test
	public void testGetExpenseOptions() {
		Expense expense = new Expense();
		User user = new User();

		user.setUserId(1);
		Optional<User> userObj = Optional.of(user);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);
		// 1.
		GetExpenseOptionsRequest request = new GetExpenseOptionsRequest();
		request.setUserId(1);
		// 2.
		GetExpenseOptionsResponse response = expenseServiceImpl.getExpenseOptions(request);

		// 3.
		assertEquals("000", response.statusCode);

	}

	@Test
	public void testGetExpenseOptionsNotPresent() {
		Expense expense = new Expense();
		User user = new User();

		user.setUserId(1);
		Optional<User> userObj = Optional.empty();

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);
		// 1.
		GetExpenseOptionsRequest request = new GetExpenseOptionsRequest();
		request.setUserId(1);
		// 2.
		GetExpenseOptionsResponse response = expenseServiceImpl.getExpenseOptions(request);

		// 3.
		assertEquals("002", response.statusCode);

	}

}
