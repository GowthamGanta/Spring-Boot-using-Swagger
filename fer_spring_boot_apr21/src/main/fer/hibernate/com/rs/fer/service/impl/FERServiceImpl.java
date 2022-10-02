package com.rs.fer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.rs.fer.bean.Expense;
import com.rs.fer.entity.User;
import com.rs.fer.util.HibernateUtil;

public class FERServiceImpl implements com.rs.fer.service.FERService {

	@Override
	public boolean registration(User user) {
	}

	public boolean login(String username, String password) {
	}

	@Override
	public boolean addExpense(Expense expense) {
		boolean isAddExpense = true;

		Session session = HibernateUtil.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(expense);

		isAddExpense = (int) session.save(expense) > 0;

		transaction.commit();
		session.close();
		return isAddExpense;
	}

	@Override
	public boolean editExpense(Expense expense) {
		boolean isEditExpense = true;

		Session session = HibernateUtil.openSession();
		try {
			Transaction transaction = session.beginTransaction();

			session.update(expense);
			transaction.commit();

		} catch (Exception ex) {
			isEditExpense = false;
		}
		session.close();

		return isEditExpense;
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
	public List<com.rs.fer.entity.Expense> getExpenseReport(int userId, String expensetype, String fromdate, String todate) {
		List<com.rs.fer.entity.Expense> ExpenseReport = new ArrayList<>();
		Session session = HibernateUtil.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userId", userId));
		criteria.add(Restrictions.eq("type", expensetype));
		criteria.add(Restrictions.between("date", fromdate, todate));
		ExpenseReport = criteria.list();

		session.close();

		return ExpenseReport;
	}


	@Override
	public User getUser(int userid) {
		User user = null;
		Session session = HibernateUtil.openSession();
		user = (User) session.get(User.class, userid);

		session.close();
		return user;
	}


	@Override
	public boolean updateUser(User user) {
	}

}
