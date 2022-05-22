package com.rs.fer.expense.util;

import com.rs.fer.bean.Expense;
import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.request.EditExpenseRequest;


public interface ExpenseUtil {

	Expense loadAddExpenseRequestToExpense(AddExpenseRequest request);

	Expense loadEditExpenseRequestToExpense(EditExpenseRequest request);

	Expense loadDeleteExpenseRequestToExpense(DeleteExpenseRequest request);
	
}
