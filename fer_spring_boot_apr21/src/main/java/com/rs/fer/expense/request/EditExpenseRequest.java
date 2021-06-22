/**
 * 
 */
package com.rs.fer.expense.request;

/**
 * @author Satish
 *
 */
public class EditExpenseRequest {
	
	private int expenseId;

	private String type;

	private String date;

	private float price;

	private int numberOfItems;

	private float total;

	private String bywhom;
	
	

	
	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseid) {
		this.expenseId = expenseid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getBywhom() {
		return bywhom;
	}

	public void setBywhom(String bywhom) {
		this.bywhom = bywhom;
	}

		
	
}
