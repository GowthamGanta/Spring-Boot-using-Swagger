package com.rs.fer.expense.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.expense.entity.Expense;
import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.request.EditExpenseRequest;
import com.rs.fer.expense.request.ExpenseReportRequest;
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
		expense.setUserId(request.getUserId());

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

	@Override
	public Expense loadExpenseReportRequestToExpense(ExpenseReportRequest request) {
		Expense expense = new Expense();

		expense.setType(request.getType());
		expense.setDate(request.getFromDate());
		expense.setDate(request.getToDate());

		return expense;
	}

}
