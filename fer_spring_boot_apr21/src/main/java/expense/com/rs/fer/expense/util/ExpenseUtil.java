package com.rs.fer.expense.util;

import com.rs.fer.expense.entity.Expense;
import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.request.EditExpenseRequest;
import com.rs.fer.expense.request.ExpenseReportRequest;

public interface ExpenseUtil {

	Expense loadAddExpenseRequestToExpense(AddExpenseRequest request);

	Expense loadEditExpenseRequestToExpense(EditExpenseRequest request, Expense expense);

	Expense loadDeleteExpenseRequestToExpense(DeleteExpenseRequest request);

	Expense loadExpenseReportRequestToExpense(ExpenseReportRequest request);

}
