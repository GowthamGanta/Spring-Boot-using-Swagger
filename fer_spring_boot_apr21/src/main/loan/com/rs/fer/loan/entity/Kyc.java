package com.rs.fer.loan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private int applicantId;

	public Kyc() {

	}

	public Kyc(String docType, String docCode, String dateOfIssue, String dateOfExpiry, String placeOfIssue) {

		this.docType = docType;
		this.docCode = docCode;
		this.dateOfIssue = dateOfIssue;
		this.dateOfExpiry = dateOfExpiry;
		this.placeOfIssue = placeOfIssue;

	}

	public int getKycId() {
		return kycId;
	}

	public void setKycId(int kycId) {
		this.kycId = kycId;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocCode() {
		return docCode;
	}

	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}

	public String getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(String dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public String getPlaceOfIssue() {
		return placeOfIssue;
	}

	public void setPlaceOfIssue(String placeOfIssue) {
		this.placeOfIssue = placeOfIssue;
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

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

}
