package com.rs.fer.expense.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
