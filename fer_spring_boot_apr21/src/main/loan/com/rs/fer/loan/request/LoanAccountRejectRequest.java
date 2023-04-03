package com.rs.fer.loan.request;

public class LoanAccountRejectRequest {

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
