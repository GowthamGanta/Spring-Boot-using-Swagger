package com.rs.fer.loan.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Applicant {

	@Id
	@Column(name = "applicant_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer applicantId;

	@Column
	private String firstName;

	@Column
	private String middleName;

	@Column
	private String lastName;

	@Column
	private char gender;

	@Column
	private String dob;

	@Column
	private char maritalStatus;
	
	@Column
	private String citizenship;

	@Column
	private String religion;

	@Column
	private String created;

	@Column
	private String updated;

	@Column(name = "loan_acc_id", insertable = false)
	private int loanAccountId;

	public Applicant() {

	}

	public Applicant(String firstName, String middleName, String lastName, char gender, String dob, char maritalStatus,
			String citizenship, String religion) {

		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.maritalStatus = maritalStatus;
		this.citizenship = citizenship;
		this.religion = religion;

	}

	@OneToMany(targetEntity = LoanAddress.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "appl_id", referencedColumnName = "applicant_id")
	private Set<LoanAddress> addresses;
	
	@OneToMany(targetEntity = Kyc.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "appl_id", referencedColumnName = "applicant_id")
	private Set<Kyc> kycList;
	
	@OneToMany(targetEntity = Mobile.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "appl_id", referencedColumnName = "applicant_id")
	private Set<Mobile> mobiles;
	
	@OneToMany(targetEntity = Email.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "appl_id", referencedColumnName = "applicant_id")
	private Set<Email> emails;

	@OneToOne(targetEntity = Employment.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id", referencedColumnName = "employment_id")
	private Employment employment;

	@OneToOne(targetEntity = FinancialDetails.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fin_id", referencedColumnName = "financial_id")
	private FinancialDetails financialDetails;

	}
