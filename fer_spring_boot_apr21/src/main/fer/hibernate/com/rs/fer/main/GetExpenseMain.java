package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetExpenseMain {

	public static void main(String[] args) {

		// 1.To load the input
		int expenseId = 10;

		// 2. To call the service for the business logic execution
		FERService ferService = new FERServiceImpl();
		Expense expense = ferService.getExpense(expenseId);

		// 3.To display the output
		if (expense == null) {
			System.out.println("Expense not found");
		} else {
			System.out.println("Expense Type: " + expense.getType());
			System.out.println("Date: " + expense.getDate());
			System.out.println("Price: " + expense.getPrice());
			System.out.println("Number of Items: " + expense.getNumberOfItems());
			System.out.println("Total: " + expense.getTotal());
			System.out.println("By whom: " + expense.getBywhom());
		}
	}

}
