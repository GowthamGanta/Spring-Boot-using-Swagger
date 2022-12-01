package com.rs.fer.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.rs.fer.bean.Address;
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
	public boolean login(String username, String password) {

		boolean isValidUser = false;

Session session = HibernateUtil.getSessionFactory().openSession();
       
		Criteria criteria = session.createCriteria(User.class);
		
		criteria.add(Restrictions.eq("username", "username"));
		
		criteria.add(Restrictions.eq("password", "password"));
		
	List<User> users = criteria.list();
	if(users !=null && !users.isEmpty()) {
		isValidUser = true;
	}
		session.close();
		
		return isValidUser;
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
		
		boolean isUserUpdate = true;

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.update(user);
			transaction.commit(); 
		} catch (Exception ex) {
			ex.printStackTrace();
			isUserUpdate = false;
		}
		
		session.close();

		return isUserUpdate;

		
	}
	
}
