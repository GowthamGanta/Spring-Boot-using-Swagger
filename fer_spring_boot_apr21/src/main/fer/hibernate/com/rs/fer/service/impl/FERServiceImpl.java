package com.rs.fer.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.entity.User;
import com.rs.fer.service.FERService;
import com.rs.fer.utill.HibernateUtil;

public class FERServiceImpl  implements FERService {

	@Override
	public boolean registration(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int login(String username, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addExpense(Expense expense) {
		boolean isAddExpense = false;

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		isAddExpense = (int) session.save(expense) > 0;
		transaction.commit();

		session.close();

		return isAddExpense;
	}

	@Override
	public boolean editExpense(Expense expense) {

		boolean isEditExpense = true;

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Transaction transaction = session.beginTransaction();
			session.update(expense);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			isEditExpense = true;

		}
		session.close();

		return isEditExpense;
	}
	@Override
	public boolean deleteExpense(int expenseId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean resetPassword(int userId, String currentPassword, String newPassword) {
		boolean isReset = false;

		Session session = HibernateUtil.getSessionFactory().openSession();

		Query query = session.createQuery("update User u set u.password=:pass, u.password=:password where u.id=:id ");

		query.setParameter("id", userId);
		query.setParameter("pass", currentPassword);
		query.setParameter("password", newPassword);

		int numberOfRecAffected = query.executeUpdate();
		isReset = numberOfRecAffected > 0;

		Transaction transaction = session.beginTransaction();

		transaction.commit();
		session.close();

		return isReset;
	}

	@Override
	public com.rs.fer.entity.Expense getExpense(int expenseId) {

		Expense expense = null;

		Session session = HibernateUtil.getSessionFactory().openSession();

		expense = (Expense) session.get(Expense.class, expenseId);
		session.close();

		return expense;
			return null;
	}

	@Override
	public List<com.rs.fer.entity.Expense> getExpenseOptions(int userId) {
		List<Expense> getexpenseOptions = null;

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(Expense.class);
		criteria.add(Restrictions.eq("userId", userId));

		getexpenseOptions = criteria.list();

		return getexpenseOptions;
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

		Session session = HibernateUtil.getSessionFactory().openSession();

		user = (User) session.get(User.class, userId);
		if (user.getAddress() == null) {
			user.setAddress(new Address());
		}
		session.close();

		return user;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
