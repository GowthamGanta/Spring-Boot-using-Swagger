package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class AddExpenseMain {

	
	public static void main(String[] args) {
		
		//1.To load the input
		Expense expense = new Expense();
		expense.setType("juice");
		expense.setDate("19-10-2021");
		expense.setPrice(25);
		expense.setNumberOfItems(4);
		expense.setTotal(200);
		expense.setBywhom("chintu");
		expense.setUserId(2);
	
		//2. To call the service for the business logic execution
		
		FERService ferService = new FERServiceImpl();
		boolean isAddedExpense = ferService.addExpense(expense);
		
		//3.To display the output
		if(isAddedExpense) {
		System.out.println("Expenses added succesfully");	
		}
		else
		{
			System.out.println("Expense is not added succesfully");
		}
	}

}
