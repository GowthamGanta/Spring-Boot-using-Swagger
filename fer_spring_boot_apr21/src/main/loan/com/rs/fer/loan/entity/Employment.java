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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	}
