package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class EditExpenseMain {

	
	public static void main(String[] args) {
		
		//1.To load the input
		Expense expense = new Expense();
		expense.setType("Coffee");
		expense.setDate("19-10-2021");
		expense.setPrice(25);
		expense.setNumberOfItems(10);
		expense.setTotal(200);
		expense.setBywhom("tinku");
		expense.setId(20);
		expense.setUserId(2);
	
		//2. To call the service for the business logic execution
		
		FERService ferService = new FERServiceImpl();
		boolean isEditedExpense = ferService.editExpense(expense);
		
		//3.To display the output
		if(isEditedExpense) {
		System.out.println("Expenses Edited succesfully");	
		}
		else
		{
			System.out.println("Expense is not Edited succesfully");
		}
	}

}
