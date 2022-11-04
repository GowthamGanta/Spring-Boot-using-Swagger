package com.rs.fer.service;

import java.util.List;

import com.rs.fer.entity.Expense;
import com.rs.fer.entity.User;

public interface FERService {

	boolean registration(User user);
	
	int login(String username, String password);
	
	boolean addExpense(Expense expense);

	
	boolean editExpense(Expense expense);
	
	boolean deleteExpense(int expenseId);
	
	boolean resetPassword(int userId, String currentPassword, String newPassword);

	Expense getExpense(int expenseId);

	List<Expense> getExpenseOptions(int userId);
	
	List<Expense> getExpenseReport(int userId, String expenseType, String fromDate, String toDate);

	User getUser(int userId);

	boolean updateUser(User user);
	
	
}
