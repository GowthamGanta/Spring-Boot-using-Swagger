package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class DeleteExpenseMain2 {

	public static void main(String[] args) {
		
		int id=4;
		
		FERService ferService = new FERServiceImpl();
		boolean isDeletedExpense = ferService.deleteExpense(id);
		
		//3.To display the output
		if(isDeletedExpense) {
		System.out.println("Expense Deleted succesfully");	
		}
		else
		{
			System.out.println("Expense is not Deleted succesfully");
		}
		
	}

}
