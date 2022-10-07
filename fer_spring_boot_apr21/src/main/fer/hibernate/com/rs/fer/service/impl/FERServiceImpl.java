package com.rs.fer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.rs.fer.bean.Expense;
import com.rs.fer.entity.User;
import com.rs.fer.util.HibernateUtil;

public class FERServiceImpl implements com.rs.fer.service.FERService {

	@Override
	public boolean registration(User user) {
		boolean isRegister = true;

		Session session = HibernateUtil.openSession();

		Transaction transaction = session.beginTransaction();

		isRegister = (int) session.save(user) > 0;

		transaction.commit();
		session.close();
		return isRegister;
	}

	@Override
	public int login(String username, String password) {
		int userId = 0;

		Session session = HibernateUtil.openSession();

		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));

		List<User> users = criteria.list();

		if (users != null && !users.isEmpty()) {
			userId = users.get(0).getId();

		}
		session.close();
		return userId;
	}

	@Override
	public boolean addExpense(Expense expense) {
		boolean isAddExpense = true;

		Session session = HibernateUtil.openSession();

		Transaction transaction = session.beginTransaction();

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
	public boolean deleteExpense(int expenseid) {
		boolean isDeleted = true;
		Session session = HibernateUtil.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			Expense expense = new Expense();
			expense.setId(expenseid);
			session.delete(expense);
			transaction.commit();
			
		}catch(Exception ex){
			isDeleted =false;
		}
		session.close();
		return isDeleted;
	}


	public boolean resetPassword(int userId, String currentPassword, String newPassword) {
		boolean isResetPassword = false;
		
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("update User u set u.password=? where u.id=? and u.password=?");
		query.setParameter(0, newPassword);
		query.setParameter(1, userId);
		query.setParameter(2, currentPassword);
		
		isResetPassword = query.executeUpdate() > 0;
		
		transaction.commit();
		session.close();
		
		return isResetPassword;
	}

	@Override
	public com.rs.fer.entity.Expense getExpense(int expenseId) {
		Expense expense = null;
		
		Session session = HibernateUtil.openSession();
		expense = (Expense) session.get(Expense.class, expenseId);

		session.close();
		
		return expense;
	}

	@Override
	public List<Expense> getExpenseOptions(int userid) {
		List<Expense> expenseoptions = null;
		Session session = HibernateUtil.openSession();
		Criteria criteria = session.createCriteria(Expense.class);
		criteria.add(Restrictions.eq("userId", userid));

		expenseoptions = criteria.list();
		session.close();

		return expenseoptions;
	}

	@Override
	public List<Expense> getExpenseReport(int userId, String expensetype, String fromdate, String todate) {
		List<Expense> ExpenseReport = new ArrayList<>();
		Session session = HibernateUtil.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userId", userId));
		criteria.add(Restrictions.eq("type", expensetype));
		criteria.add(Restrictions.between("date", fromdate, todate));
		ExpenseReport = criteria.list();

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
		boolean isUpdateUser = false;
		Session session = HibernateUtil.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();

		} catch (Exception ex) {
			isUpdateUser = true;

		}
		session.close();
		return isUpdateUser;
	}
}
