package com.rs.fer.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
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
		
		Session session = HibernateUtil.openSession();

		try {
			Transaction transaction = session.beginTransaction();
			session.update(expense);
			transaction.commit();

			isEditedExpense = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		session.close();

		return isEditedExpense;

	}

	@Override
	public boolean deleteExpense(int id) {

		boolean isDeletedExpense = false;

		return isDeletedExpense;
	}

	@Override
	public boolean resetPassword(int id, String currentPassword, String newPassword) {
		
		boolean isresetpassword= false;
		
		Session session = HibernateUtil.openSession();
		Query query = session.createQuery("update User u set u.password=? where u.id=? and u.password=?");
		query.setParameter(0, newPassword);
		query.setParameter(1, id);
		query.setParameter(2, currentPassword);
		
		
		int numberOfRecAffected = query.executeUpdate();
		isresetpassword = numberOfRecAffected > 0;

        session.close();

		return isresetpassword;	
	}

	@Override
	public Expense getExpense(int expenseId) {
		Expense expense = null;

		return expense;
	}

	@Override
	public List<Expense> getExpenseOptions(int userId) {
		// Expense expense = null;

		Session session = HibernateUtil.openSession();

		Criteria criteria = session.createCriteria(Expense.class);
		criteria.add(Restrictions.eq("userid", userid));

		List<Expense> expenses = criteria.list();

		session.close();

		return expenses;
	}

	@Override
	public List<Expense> getExpenseReport(int userId, String expenseType, String fromDate, String toDate) {
		
		Session session = HibernateUtil.openSession();
		
		Criteria criteria = session.createCriteria(Expense.class);
		
		criteria.add(Restrictions.eq("userId", userId));
		criteria.add(Restrictions.eq("expenseType", expenseType));
		criteria.add(Restrictions.between("date", fromDate, toDate));
		
		List<Expense> expenseReport = criteria.list();
		return expenseReport;
	}

	@Override
	public User getUser(int userId) {
		User user = null;

		
	Session session = HibernateUtil.openSession();
		
		user= (User) session.get(User.class, userId);
	    if(user.getAddress()==null) {
	    	user.setAddress(new Address());
	    }
		
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
	       
	       isUpdateUser=true;
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		   session.close();

		
		
		return isUpdateUser;
	}

}
