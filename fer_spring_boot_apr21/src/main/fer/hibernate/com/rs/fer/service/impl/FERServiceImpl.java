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
		boolean isResetPassword = false;

		Session session = HibernateUtil.openSession();
		
		Query query = session.createQuery("update User u set u.password=:new where u.id and u.password=:old");
		
		query.setParameter("new", newPassword);
		query.setParameter("id", userId);
		query.setParameter("old", newPassword);
		
		isResetPassword = query.executeUpdate() > 0;
		
		return isResetPassword;
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
