package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetExpenseReportMain {

	public static void main(String[] args) {

		// 1. get the input
		int userId = 3;
		String expenseType = "tea";
		String fromDate = "10-07-2022";
		String toDate = "10-07-2022";
		// 2. pass the input to service layer business logic execution
		FERService ferService = new FERServiceImpl();
		List<Expense> expenseReport = ferService.getExpenseReport(userId, expenseType, fromDate, toDate);

		// 3. display output
		if (expenseReport.isEmpty()) {
			System.out.println("Expense not found");
		} else {

			for (Expense expense : expenseReport) {

				// b. print the expense data in console view
				System.out.println("ID :" + expense.getId());
				System.out.println("type :" + expense.getType());
				System.out.println("date :" + expense.getDate());
				System.out.println("price :" + expense.getPrice());
				System.out.println("numberofitems :" + expense.getNumberOfItems());

				System.out.println("total :" + expense.getTotal());
				System.out.println("bywhom :" + expense.getBywhom());
				System.out.println("userid :" + expense.getUserId());

				System.out.println("...............");
			}

		}

	}
}
