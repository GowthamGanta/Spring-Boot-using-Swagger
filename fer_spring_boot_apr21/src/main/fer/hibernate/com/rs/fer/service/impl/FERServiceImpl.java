package com.rs.fer.service.impl;

import java.util.List;

import com.rs.fer.entity.User;

public class FERServiceImpl implements com.rs.fer.service.FERService {

	@Override
	public boolean registration(User user) {
	}

	public boolean login(String username, String password) {
	}

	@Override
	public boolean addExpense(com.rs.fer.entity.Expense expense) {
	}

	@Override
	public boolean editExpense(com.rs.fer.entity.Expense expense) {
	}

	@Override
	public boolean deleteExpense(int expenseId) {
	}

	@Override
	public boolean resetPassword(int userId, String currentPassword, String newPassword) {
	}

	@Override
	public com.rs.fer.entity.Expense getExpense(int expenseId) {
	}

	@Override
	public List<com.rs.fer.entity.Expense> getExpenseOptions(int userId) {
	}

	@Override
	public List<com.rs.fer.entity.Expense> getExpenseReport(int userId, String expenseType, String fromDate,
			String toDate) {
	}

	@Override
	public User getUser(int userId) {
	}

	@Override
	public boolean updateUser(User user) {
	}

}
