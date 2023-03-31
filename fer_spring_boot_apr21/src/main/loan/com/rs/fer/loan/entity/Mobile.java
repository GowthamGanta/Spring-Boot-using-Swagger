package com.rs.fer.loan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Mobile {

	@Id
	@Column(name = "mobile_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mobileId;

	@Column
	private int countryCode;

	@Column
	private String number;

	@Column
	private String flag;

	@Column
	private String created;

	@Column
	private String updated;

	@Column(name = "appl_id", insertable = false)
	private Integer applicantId;

	public Mobile() {

	}

	public Mobile(int countryCode, String number, String flag) {
		this.countryCode = countryCode;
		this.number = number;
		this.flag = flag;

	}

	public int getMobileId() {
		return mobileId;
	}

	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public Integer getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}
}
