package com.rs.fer.expense.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

public class ExpenseReportResponse {

     private String type;
	 
	 private String fromDate ;
	 
	 private String toDate ;

	public ExpenseReportResponse(HttpStatus preconditionFailed, String string, Object object,
			Set<String> errorMessages) {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFromDate() {
		return fromDate;
		
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	 
}
