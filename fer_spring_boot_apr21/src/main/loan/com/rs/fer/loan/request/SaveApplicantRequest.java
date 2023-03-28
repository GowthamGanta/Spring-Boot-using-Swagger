package com.rs.fer.loan.request;

import java.util.Set;

public class SaveApplicantRequest {

	private String firstName;
	private String middleName;
	private String lastName;
	private char gender;
	private String dob;
	private char maritalStatus;
	private String citizenship;
	private String religion;

	private Set<EmailDTO> emails;
	private EmploymentDTO employment;
	private FinancialDetailsDTO financialDetails;
	private Set<KycDTO> kyc;
	private Set<MobileDTO> mobiles;
	private Set<LoanAddressDTO> loanAddresses;

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

	public Set<EmailDTO> getEmails() {
		return emails;
	}

	public void setEmails(Set<EmailDTO> emails) {
		this.emails = emails;
	}

	public EmploymentDTO getEmployment() {
		return employment;
	}

	public void setEmployment(EmploymentDTO employment) {
		this.employment = employment;
	}

	public FinancialDetailsDTO getFinancialDetails() {
		return financialDetails;
	}

	public void setFinancialDetails(FinancialDetailsDTO financialDetails) {
		this.financialDetails = financialDetails;
	}

	public Set<KycDTO> getKyc() {
		return kyc;
	}

	public void setKyc(Set<KycDTO> kyc) {
		this.kyc = kyc;
	}

	public Set<MobileDTO> getMobiles() {
		return mobiles;
	}

	public void setMobiles(Set<MobileDTO> mobiles) {
		this.mobiles = mobiles;
	}

	public Set<LoanAddressDTO> getLoanAddresses() {
		return loanAddresses;
	}

	public void setLoanAddresses(Set<LoanAddressDTO> loanAddresses) {
		this.loanAddresses = loanAddresses;
	}

}
