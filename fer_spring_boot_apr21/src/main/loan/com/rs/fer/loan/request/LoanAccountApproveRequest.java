package com.rs.fer.loan.request;

public class LoanAccountApproveRequest {

	private int loanAccountId;

	private String status;

	public int getLoanAccountId() {
		return loanAccountId;
	}

	public void setLoanAccountId(int loanAccountId) {
		this.loanAccountId = loanAccountId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
