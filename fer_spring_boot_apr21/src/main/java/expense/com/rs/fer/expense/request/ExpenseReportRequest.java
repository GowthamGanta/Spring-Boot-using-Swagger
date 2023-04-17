package com.rs.fer.expense.request;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ExpenseReportRequest {
	
	private String type;

	private String fromDate;

	private String toDate;

	private int UserId;
}
