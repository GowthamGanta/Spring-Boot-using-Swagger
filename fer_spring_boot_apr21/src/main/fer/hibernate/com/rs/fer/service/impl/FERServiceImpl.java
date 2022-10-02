package com.rs.fer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.rs.fer.bean.Expense;
import com.rs.fer.entity.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.Impl.FERServiceImpl;
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
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			int userId = 1;
			String currentPassword = "vinni";
			String newPassword = "2";

			FERService ferservice = new FERServiceImpl();
			boolean isResetPassword = ferservice.resetPassword(userId, currentPassword, newPassword);

			if (isResetPassword) {
				System.out.println("password changed successfully...!");
			} else {
				System.out.println("password changed failed.....");
			}

		
	}

	@Override
	public com.rs.fer.entity.Expense getExpense(int expenseId) {
		
		
	}

	@Override
	public List<com.rs.fer.entity.Expense> getExpenseOptions(int userId) {
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
