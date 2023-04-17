package com.rs.fer.loan.request;

import com.rs.fer.loan.entity.LoanAddress;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmploymentDTO {
	
	private String employmentStatus;
	
	private String employerName;
	
	private LoanAddress employerAddress;
	
	private String others;
}
