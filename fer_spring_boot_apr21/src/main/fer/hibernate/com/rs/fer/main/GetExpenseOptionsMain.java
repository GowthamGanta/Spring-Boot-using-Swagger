package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetExpenseOptionsMain {

	public static void main(String[] args) {

		// 1.To load the input
		int userId = 100;

		// 2. To call the service for the business logic execution
		FERService ferService = new FERServiceImpl();
		List<Expense> expenseOptions = ferService.getExpenseOptions(userId);

		// 3.To display the output
		if (expenseOptions.isEmpty()) {
			System.out.println("Expense not found");
		} else {
			for(Expense expense : expenseOptions) {
				System.out.println("Expense Type: " + expense.getType());
				System.out.println("Date: " + expense.getDate());
				System.out.println("Price: " + expense.getPrice());
				System.out.println("Number of Items: " + expense.getNumberOfItems());
				System.out.println("Total: " + expense.getTotal());
				System.out.println("By whom: " + expense.getBywhom());
				
				System.out.println(".........................................");
			}
		}
	}

}
