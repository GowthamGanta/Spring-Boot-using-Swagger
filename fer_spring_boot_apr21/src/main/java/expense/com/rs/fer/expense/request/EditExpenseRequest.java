/**
 * 
 */
package com.rs.fer.expense.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Satish
 *
 */
@Getter
@Setter
public class EditExpenseRequest {
	
	private int expenseId;

	private String type;
 
	private String date;

	private float price;

	private int numberOfItems;

	private float total;

	private String bywhom;
	
	private int userId;
	
	
}
