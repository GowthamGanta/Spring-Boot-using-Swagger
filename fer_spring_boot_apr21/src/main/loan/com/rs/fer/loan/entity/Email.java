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

	@Column(name = "appl_id", insertable = false)
	private Integer applicantId;

	public Email() {

	}

	public Email(String emailAddress, String flag) {
		this.emailAddress = emailAddress;
		this.flag = flag;

	}
}
