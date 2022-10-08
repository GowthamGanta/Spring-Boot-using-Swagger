package com.rs.fer.expense.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.entity.Expense;
import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.request.EditExpenseRequest;
import com.rs.fer.expense.request.GetExpenseRequest;
import com.rs.fer.expense.util.ExpenseUtil;
import com.rs.fer.util.DateUtil;

@Component
public class ExpenseUtilImpl implements ExpenseUtil {

	@Override
	public Expense loadAddExpenseRequestToExpense(AddExpenseRequest request) {

		Expense expense = new Expense();
		expense.setType(request.getType());
		expense.setDate(request.getDate());
		expense.setPrice(request.getPrice());
		expense.setNumberOfItems(request.getNumberOfItems());
		expense.setTotal(request.getTotal());
		expense.setBywhom(request.getBywhom());
		expense.setUser_id(request.getUserId());
		
		expense.setCreated(DateUtil.getCurrentDate());


		return expense;
	}
	@Override
	public Expense loadEditExpenseRequestToExpense(EditExpenseRequest request) {

		Expense expense = new Expense();
		
		expense.setExpenseId(request.getExpenseId());
		expense.setExpenseId(request.getExpenseId());
		expense.setType(request.getType());
		expense.setDate(request.getDate());
		expense.setPrice(request.getPrice());
		expense.setNumberOfItems(request.getNumberOfItems());
		expense.setTotal(request.getTotal());
		expense.setBywhom(request.getBywhom());

	expense.setUpdated(DateUtil.getCurrentDate());


		return expense;
	}

	@Override
	public Expense loadDeleteExpenseRequestToExpense(DeleteExpenseRequest request) {

		Expense expense = new Expense();
		expense.setExpenseId(request.getExpenseid());
	
		return expense;
	}
	
}
