package com.rs.fer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Expense {
	@Id
	@Column(name = "expense_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer expenseId;

	@Column
	private String type;

	@Column
	private String date;

	@Column
	private float price;

	@Column
	private int numberOfItems;

	@Column
	private float total;

	@Column
	private String bywhom;

	@Column
	private String created;

	@Column
	private String updated;

	@Column(name="user_id")
	private int userId;

	public Expense() {

	}

	public Expense(int expenseId, String type, String date, float price, int numberOfItems, float total,
			String bywhom) {

		this.expenseId = expenseId;

		this.type = type;
		this.date = date;
		this.price = price;
		this.numberOfItems = numberOfItems;
		this.total = total;
		this.bywhom = bywhom;

	}

	public Integer getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

}
