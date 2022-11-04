package com.rs.fer.main;

import com.rs.fer.entity.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class EditExpenseMain {

	public static void main(String[] args) {

		// 1.Get the input from UI

		Expense expense = new Expense();
		expense.setType("LUNCH");
		expense.setDate("01/09/2022");
		expense.setPrice(12);
		expense.setNumberOfItems(2);
		expense.setTotal(24);
		expense.setBywhom("me");
		expense.setUserId(2);
		expense.setId(2);

		// 2. call the service the business logic execution

		FERService ferservice = new FERServiceImpl();
		boolean isEditExpense = ferservice.editExpense(expense);

		// 3.Display the output

		if (isEditExpense) {
			System.out.println("Expense edit is successful");
		} else {
			System.out.println("Expense edit is failed");
		}

	}

}
