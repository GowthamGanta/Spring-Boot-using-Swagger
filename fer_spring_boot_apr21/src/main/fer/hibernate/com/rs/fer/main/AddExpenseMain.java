package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class AddExpenseMain {

	public static void main(String[] args) {

		// 1. Get the input
		Expense expense = new Expense();
		expense.setType("dygsf");
		expense.setDate("01-08-2022");
		expense.setPrice(15);
		expense.setNumberOfItems(6);
		expense.setTotal(5000);
		expense.setBywhom("Me");
		expense.setUserId(4);
		// 2. Pass the input to service layer for business logic execution
		FERService ferService = (FERService) new FERServiceImpl();
		boolean isAddExpense = ferService.addExpense(expense);

		// 3. Display the output
		if (isAddExpense) {
			System.out.println("Expense Added successfuly......");
		} else {
			System.out.println("Expense Added is failed...");
		}

	}

}
