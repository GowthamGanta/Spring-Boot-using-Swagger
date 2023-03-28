package com.rs.fer.loan.request;

import com.rs.fer.loan.entity.LoanAddress;

public class EmploymentDTO {
	private String employmentStatus;
	private String employerName;
	private LoanAddress employerAddress;

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public LoanAddress getEmployerAddress() {
		return employerAddress;
	}

	public void setEmployerAddress(LoanAddress employerAddress) {
		this.employerAddress = employerAddress;
	}

}
