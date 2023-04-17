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
public class Kyc {

	@Id
	@Column(name = "kyc_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int kycId;

	@Column
	private String docType;

	@Column
	private String docCode;

	
	@Column
	private String dateOfIssue;

	@Column
	private String dateOfExpiry;

	@Column
	private String placeOfIssue;

	@Column
	private String created;

	@Column
	private String updated;

	@Column(name = "appl_id", insertable = false)
	private Integer applicantId;

	public Kyc() {

	}

	public Kyc(String docType, String docCode, String dateOfIssue, String dateOfExpiry, String placeOfIssue) {

		this.docType = docType;
		this.docCode = docCode;
		this.dateOfIssue = dateOfIssue;
		this.dateOfExpiry = dateOfExpiry;
		this.placeOfIssue = placeOfIssue;

	
	}
	}
