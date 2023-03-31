package com.rs.fer.loan.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Employment {

	@Id
	@Column(name = "employment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employmentId;

	@Column
	private String employmentStatus;

	@Column
	private String employerName;

	@OneToOne(targetEntity = LoanAddress.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "addr_id", referencedColumnName = "address_id")
	private LoanAddress employerAddress;

	@Column
	private String others;
	
	@Column
	private String created;

	@Column
	private String updated;

	@Column(name = "applicant_id")
	private Integer applicantId;

	public Employment() {

	}

	public Employment(String employmentStatus, String employerName) {
		this.employmentStatus = employmentStatus;
		this.employerName = employerName;

	}

	public int getEmploymentId() {
		return employmentId;
	}

	public void setEmploymentId(int employmentId) {
		this.employmentId = employmentId;
	}

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

	
	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
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
