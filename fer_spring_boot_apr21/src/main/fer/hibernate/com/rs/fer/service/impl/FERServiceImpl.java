package com.rs.fer.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		int userId = (int) session.save(user);
		isRegister = userId > 0;
		transaction.commit();

		session.close();

		return isRegister;
	}

	@Override
	public boolean login(String username, String password) {
		boolean isValidUser = false;
		Session session = HibernateUtil.openSession();

		Criteria criteria = session.createCriteria(User.class);

		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));
		List<User> users = criteria.list();
		isValidUser = (users != null && !users.isEmpty());

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
		//Expense expense = null;
		
		Session session = HibernateUtil.openSession();
		
		Criteria criteria = session.createCriteria(Expense.class);
		
		criteria.add(Restrictions.eq("userId", userId));
		criteria.add(Restrictions.eq("expenseType", expenseType));
		criteria.add(Restrictions.eq("date", fromDate));
		criteria.add(Restrictions.eq("date", toDate));
		
		List<Expense> expenseReport = criteria.list();
		return expenseReport;
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
