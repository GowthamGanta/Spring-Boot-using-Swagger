package com.rs.fer.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rs.fer.entity.Address;
import com.rs.fer.entity.Expense;
import com.rs.fer.entity.User;
import com.rs.fer.service.FERService;
import com.rs.fer.util.DBUtil;
import com.rs.fer.util.HibernateUtil;

public class FERServiceImpl implements FERService {

	@Override
	public boolean registration(User user) {
		boolean isRegister = false;

		
		return isRegister;
	}

	@Override
	public boolean login(String username, String password) {
		boolean isValidUser = false;

		
		return isValidUser;
	}

	@Override
	public boolean addExpense(Expense expense) {

		boolean isAddedExpense = false;

		
		return isAddedExpense;

	}

	@Override

	public boolean editExpense(Expense expense) {

		boolean isEditedExpense = false;

		
		return isEditedExpense;

	}

	@Override
	public boolean deleteExpense(int id) {

		boolean isDeletedExpense = false;

		
		return isDeletedExpense;
	}

	@Override
	public boolean resetPassword(int id, String currentPassword, String newPassword) {

		return false;
	}

	@Override
	public Expense getExpense(int expenseId) {
		Expense expense = null;

		

		return expense;
	}

	@Override
	public List<Expense> getExpenseOptions(int userId) {
		List<Expense> expenseOptions = new ArrayList<Expense>();

		
		return expenseOptions;
	}

	@Override
	public List<Expense> getExpenseReport(int userId, String expenseType, String fromDate, String toDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(int userId) {
		User user = null;

		

		return user;
	}

	@Override
	public boolean updateUser(User user) {
		boolean isUpdateUser = false;

	
		return isUpdateUser;
	}

}
