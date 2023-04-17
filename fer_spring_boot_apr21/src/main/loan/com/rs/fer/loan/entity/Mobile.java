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
}
