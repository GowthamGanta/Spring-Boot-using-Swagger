
package com.rs.fer.loan.request;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
