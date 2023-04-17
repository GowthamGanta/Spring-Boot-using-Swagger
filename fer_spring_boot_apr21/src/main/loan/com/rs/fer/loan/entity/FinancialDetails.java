package com.rs.fer.loan.entity;

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
public class FinancialDetails {

	@Id
	@Column(name = "financial_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int financialId;

	@Column
	private Float grossSalary;

	@Column
	private Float netSalary;

	@Column
	private String created;

	@Column
	private String updated;

	@Column(name = "applicant_id")
	private Integer applicantId;

	public FinancialDetails() {

	}

	public FinancialDetails(Float grossSalary, Float netSalary) {

		this.grossSalary = grossSalary;
		this.netSalary = netSalary;

	}
}
