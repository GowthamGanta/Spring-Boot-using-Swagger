package com.rs.fer.loan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Email {

	@Id
	@Column(name = "email_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emailId;

	@Column
	private String emailAddress;

	@Column
	private String flag;

	@Column
	private String created;

	@Column
	private String updated;

	@Column(name = "applicant_id")
	private int applicantId;

	public Email() {

	}

	public Email(String emailAddress, String flag) {
		this.emailAddress = emailAddress;
		this.flag = flag;

	}

	public int getEmailId() {
		return emailId;
	}

	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
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
