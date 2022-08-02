package com.rs.fer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.entity.User;
import com.rs.fer.service.FERService;
import com.rs.fer.util.HibernateUtil;

public class FERServiceImpl implements FERService {

	@Override
	public boolean registration(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean login(String username, String password) {
		int userId = 0;
		Session session = HibernateUtil.openSession();
		Criteria criteria = session.createCriteria(Expense.class);

		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));

		List<User> users = criteria.list();
		if (users != null && !users.isEmpty()) {
			userId = users.get(0).getId();
		}
		session.close();
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

		boolean isDeleteExpense = true;

		Session session = HibernateUtil.openSession();

		try {
			Transaction transaction = session.beginTransaction();

			Expense expense = new Expense();
			expense.setId(expenseId);

			session.delete(expense);

			transaction.commit();

		} catch (Exception ex) {
			isDeleteExpense = false;

		}
		session.close();

		return isDeleteExpense;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		boolean isUserUpdate = true;

	Session session = HibernateUtil.openSession();
	try {
	Transaction transaction = session.beginTransaction();

	session.update(user);
	transaction.commit();
	}catch(Exception ex) {
		isUserUpdate = false;
	}
	session.close();
	
	return isUserUpdate;
	
	
	}

	

}
