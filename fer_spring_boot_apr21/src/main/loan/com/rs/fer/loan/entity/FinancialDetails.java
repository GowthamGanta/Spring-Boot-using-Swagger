package com.rs.fer.loan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	public int getFinancialId() {
		return financialId;
	}

	public void setFinancialId(int financialId) {
		this.financialId = financialId;
	}

	public Float getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(Float grossSalary) {
		this.grossSalary = grossSalary;
	}

	public Float getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(Float netSalary) {
		this.netSalary = netSalary;
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

	public Integer getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}


}
