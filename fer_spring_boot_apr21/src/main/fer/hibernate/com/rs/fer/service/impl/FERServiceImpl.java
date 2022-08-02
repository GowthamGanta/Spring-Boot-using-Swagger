package com.rs.fer.service.impl;

import java.util.List;

import org.hibernate.Session;

import com.rs.fer.entity.User;

import main.fer.hibernate.com.rs.fer.service.FERService;
import main.fer.hibernate.com.rs.fer.util.HibernateUtil;

public class FERServiceImpl implements FERService {

	@Override
	public boolean registration(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addExpense(com.rs.fer.entity.Expense expense) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editExpense(com.rs.fer.entity.Expense expense) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteExpense(int expenseId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean resetPassword(int userId, String currentPassword, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public com.rs.fer.entity.Expense getExpense(int expenseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<com.rs.fer.entity.Expense> getExpenseOptions(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<com.rs.fer.entity.Expense> getExpenseReport(int userId, String expenseType, String fromDate,
			String toDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(int userId) {
		User user = null;

		Session session = HibernateUtil.openSession();
		user = (User) session.get(User.class, userID);
		session.close();

		return user;
		
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
