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

import com.rs.fer.user.entity.Address;

@Entity
@Table
public class Applicant {

	@Id
	@Column(name = "applicant_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int applicantId;

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
	@JoinColumn(name = "address_id", referencedColumnName = "applicant_id")
	private Set<LoanAddress> addresses;

	@OneToMany(targetEntity = Kyc.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "kyc_id", referencedColumnName = "applicant_id")
	private Set<Kyc> kycList;

	@OneToMany(targetEntity = Mobile.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "mobile_id", referencedColumnName = "applicant_id")
	private Set<Mobile> mobiles;

	@OneToMany(targetEntity = Email.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "email_id", referencedColumnName = "applicant_id")
	private Set<Email> emails;

	@OneToOne(targetEntity = Employment.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id", referencedColumnName = "employment_id")
	private Employment employment;

	@OneToOne(targetEntity = FinancialDetails.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fin_id", referencedColumnName = "financial_id")
	private FinancialDetails financialDetails;

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public char getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(char maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
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

	
	public Set<LoanAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<LoanAddress> addresses) {
		this.addresses = addresses;
	}

	public Set<Kyc> getKycList() {
		return kycList;
	}

	public void setKycList(Set<Kyc> kycList) {
		this.kycList = kycList;
	}

	public Set<Mobile> getMobiles() {
		return mobiles;
	}

	public void setMobiles(Set<Mobile> mobiles) {
		this.mobiles = mobiles;
	}

	public Set<Email> getEmails() {
		return emails;
	}

	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}

	public Employment getEmployment() {
		return employment;
	}

	public void setEmployment(Employment employment) {
		this.employment = employment;
	}

	public FinancialDetails getFinancialDetails() {
		return financialDetails;
	}

	public void setFinancialDetails(FinancialDetails financialDetails) {
		this.financialDetails = financialDetails;
	}

}
