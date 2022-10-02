package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetExpenseReportMain {

	public static void main(String[] args) {

		// 1. Get the input from UI
		int userId = 1;
		String expenseType = "tea";
		String fromDate = "03/09/2022";
		String toDate = "03/09/2022";

		// 2. Call the services from business logic execution
		FERService ferService = new FERServiceImpl();
		List<com.rs.fer.entity.Expense> expenseReport = ferService.getExpenseReport(userId, expenseType, fromDate, toDate);

		// 3. Display the output
		if (expenseReport.isEmpty()) {
			System.out.println("Expense is not found");
		} else {

			for (com.rs.fer.entity.Expense expense : expenseReport) {
				System.out.println("Id :" + expense.getUser_id());
				System.out.println("type :" + expense.getType());
				System.out.println("date :" + expense.getDate());
				System.out.println("price :" + expense.getPrice());
				System.out.println("numberofitems :" + expense.getNumberOfItems());
				System.out.println("total :" + expense.getTotal());
				System.out.println("byWhom :" + expense.getBywhom());
				System.out.println("userId :" + expense.getUser_id());

				System.out.println("...........");
			}

		}

	}
}