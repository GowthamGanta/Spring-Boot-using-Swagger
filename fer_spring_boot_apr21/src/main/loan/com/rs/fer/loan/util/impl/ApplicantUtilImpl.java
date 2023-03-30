package com.rs.fer.loan.util.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.loan.entity.Applicant;
import com.rs.fer.loan.entity.Email;
import com.rs.fer.loan.entity.Employment;
import com.rs.fer.loan.entity.FinancialDetails;
import com.rs.fer.loan.entity.Kyc;
import com.rs.fer.loan.entity.LoanAddress;
import com.rs.fer.loan.entity.Mobile;
import com.rs.fer.loan.request.EmailDTO;
import com.rs.fer.loan.request.EmploymentDTO;
import com.rs.fer.loan.request.FinancialDetailsDTO;
import com.rs.fer.loan.request.KycDTO;
import com.rs.fer.loan.request.LoanAddressDTO;
import com.rs.fer.loan.request.MobileDTO;
import com.rs.fer.loan.request.SaveApplicantRequest;
import com.rs.fer.loan.util.ApplicantUtil;

@Component
public class ApplicantUtilImpl implements ApplicantUtil {

	@Override
	public Applicant loadSaveApplicantRequestToApplicant(SaveApplicantRequest request) {

		Applicant applicant = new Applicant();
		Set<Email> emails = new LinkedHashSet<>();
		Set<Kyc> kycs = new LinkedHashSet<>();
		Set<Mobile> mobiles = new LinkedHashSet<>();
		Set<LoanAddress> loanAddresses = new LinkedHashSet<>();

		applicant.setFirstName(request.getFirstName());
		applicant.setMiddleName(request.getMiddleName());
		applicant.setLastName(request.getLastName());
		applicant.setGender(request.getGender());
		applicant.setDob(request.getDob());
		applicant.setMaritalStatus(request.getMaritalStatus());
		applicant.setCitizenship(request.getCitizenship());
		applicant.setReligion(request.getReligion());

		// Converting emailDTO to entity
		Email email = null;
		for (EmailDTO emailDTO : request.getEmails()) {
			email = new Email();
			email.setEmailAddress(emailDTO.getEmailAddress());
			emails.add(email);
		}
		applicant.setEmails(emails);

		// Converting KycDTO to entity
		Kyc kyc = null;
		for (KycDTO kycDTO : request.getKyc()) {
			kyc = new Kyc();
			kyc.setDocType(kycDTO.getDocType());
			kyc.setDocCode(kycDTO.getDocCode());
			kyc.setDateOfIssue(kycDTO.getDateOfIssue());
			kyc.setDateOfExpiry(kycDTO.getDateOfExpiry());
			kyc.setPlaceOfIssue(kycDTO.getPlaceOfIssue());

			kycs.add(kyc);
		}
		applicant.setKycList(kycs);

		// Converting MobileDTO to entity
		for (MobileDTO mobileDTO : request.getMobiles()) {
			Mobile mobile = new Mobile();
			mobile.setNumber(mobileDTO.getNumber());
			mobile.setCountryCode(mobileDTO.getCountryCode());

			mobiles.add(mobile);

		}
		applicant.setMobiles(mobiles);

		// Converting LoanAddressDTO to entity
		LoanAddress loanAddress = null;
		for (LoanAddressDTO loanAddressDTO : request.getLoanAddresses()) {
			loanAddress = new LoanAddress();
			loanAddress.setLineOne(loanAddressDTO.getLineOne());
			loanAddress.setLineTwo(loanAddressDTO.getLineTwo());
			loanAddress.setCity(loanAddressDTO.getCity());
			loanAddress.setState(loanAddressDTO.getState());
			loanAddress.setPincode(loanAddressDTO.getPincode());
			loanAddress.setCountry(loanAddressDTO.getCountry());

			loanAddresses.add(loanAddress);
		}
		applicant.setAddresses(loanAddresses);

		// Converting EmploymentDTO to entity
		EmploymentDTO employmentDTO = null;
		employmentDTO = request.getEmployment();
		Employment employment = new Employment();
		employment.setEmployerName(employmentDTO.getEmployerName());
		employment.setEmploymentStatus(employmentDTO.getEmploymentStatus());
		employment.setEmployerAddress(employmentDTO.getEmployerAddress());

		applicant.setEmployment(employment);

		// Converting FinancialDetailsDTO to entity
		FinancialDetailsDTO financialDetailsDTO = null;
		financialDetailsDTO = request.getFinancialDetails();
		FinancialDetails financialDetails = new FinancialDetails();
		financialDetails.setGrossSalary(financialDetailsDTO.getGrossSalary());
		financialDetails.setNetSalary(financialDetailsDTO.getNetSalary());

		applicant.setFinancialDetails(financialDetails);

		return applicant;
	}

}
