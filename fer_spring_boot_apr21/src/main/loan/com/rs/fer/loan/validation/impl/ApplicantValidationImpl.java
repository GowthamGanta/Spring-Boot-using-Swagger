package com.rs.fer.loan.validation.impl;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.loan.request.EmailDTO;
import com.rs.fer.loan.request.EmploymentDTO;
import com.rs.fer.loan.request.FinancialDetailsDTO;
import com.rs.fer.loan.request.KycDTO;
import com.rs.fer.loan.request.LoanAccountApproveRequest;
import com.rs.fer.loan.request.LoanAccountRejectRequest;
import com.rs.fer.loan.request.LoanAddressDTO;
import com.rs.fer.loan.request.MobileDTO;
import com.rs.fer.loan.request.SaveApplicantRequest;
import com.rs.fer.loan.validation.ApplicantValidation;
import com.rs.fer.util.FERUtil;

@Component
public class ApplicantValidationImpl implements ApplicantValidation {

	@Override
	public Set<String> validateSaveApplicantRequest(SaveApplicantRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getFirstName(), "Please enter First Name");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getLastName(), "Please enter Last Name");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getMaritalStatus(),
				"Please enter Marital Status");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getGender(), "Please enter Gender");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getDob(), "Please enter DOB");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getCitizenship(), "Please enter Citizenship");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getReligion(), "Please enter Religion ");

		// To validate email input
		if (request.getEmails() == null || request.getEmails().isEmpty()) {
			errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEmails(), "Please enter Email Details");
		} else {
			for (EmailDTO email : request.getEmails()) {
				errorMessages = FERUtil.addErrorIfEmpty(errorMessages, email.getEmailAddress(),
						"Please enter Email Address");
			}
		}

		// To validate KYC input
		if (request.getKyc() == null || request.getKyc().isEmpty()) {
			errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getKyc(), "Please enter Kyc Details");
		} else {
			for (KycDTO kyc : request.getKyc()) {
				errorMessages = FERUtil.addErrorIfEmpty(errorMessages, kyc.getDocType(), "Please enter Document Type");
				errorMessages = FERUtil.addErrorIfEmpty(errorMessages, kyc.getDocCode(), "Please enter Document Code ");

				// To validate Passport(PP)& DrivingLicense(DL)& AadharCard(AC)
				if (kyc.getDocType() == "PP" || kyc.getDocType() == "DL") {
					errorMessages = FERUtil.addErrorIfEmpty(errorMessages, kyc.getDateOfIssue(),
							"Please enter Date Of Issue");
					errorMessages = FERUtil.addErrorIfEmpty(errorMessages, kyc.getDateOfExpiry(),
							"Please enter Date Of Expiry");
					errorMessages = FERUtil.addErrorIfEmpty(errorMessages, kyc.getPlaceOfIssue(),
							"Please enter Place Of Issue");
				}
			}

		}

		// To validate Mobile input
		if (request.getMobiles() == null || request.getMobiles().isEmpty()) {
			errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getMobiles(), "Please enter Mobile details");
		} else {
			for (MobileDTO mobile : request.getMobiles()) {
				errorMessages = FERUtil.addErrorIfEmpty(errorMessages, mobile.getNumber(), "Please enter Mobilenumber");
				errorMessages = FERUtil.addErrorIfEmpty(errorMessages, mobile.getCountryCode(),
						"Please enter CountryCode");
			}

		}
		// To validate Address input
		if (request.getLoanAddresses() == null || request.getLoanAddresses().isEmpty()) {
			errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getLoanAddresses(),
					"Please enter LoanAddresse Details");
		} else {
			for (LoanAddressDTO address : request.getLoanAddresses()) {
				errorMessages = FERUtil.addErrorIfEmpty(errorMessages, address.getLineOne(), "Please enter LineOne");
				errorMessages = FERUtil.addErrorIfEmpty(errorMessages, address.getCity(), "Please enter City");
				errorMessages = FERUtil.addErrorIfEmpty(errorMessages, address.getCountry(), "Please enter Country");
				errorMessages = FERUtil.addErrorIfEmpty(errorMessages, address.getPincode(), "Please enter Pincode");
				errorMessages = FERUtil.addErrorIfEmpty(errorMessages, address.getState(), "Please enter State");
				errorMessages = FERUtil.addErrorIfEmpty(errorMessages, address.getAddressType(),
						"Please enter Address Type");
			}
		}

		// To Validate Employment input
		if (request.getEmployment() == null) {
			errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEmployment(),
					"Please enter Employment Details");
		} else {
			EmploymentDTO employment = request.getEmployment();

			errorMessages = FERUtil.addErrorIfEmpty(errorMessages, employment.getEmploymentStatus(),
					"Please enter Employment Status");

			// To validate employmentStatus(
			// E=Employed;SE=SelfEmployed;NE=NotEmployed;others)
			if (employment.getEmploymentStatus() == "E") {

				errorMessages = FERUtil.addErrorIfEmpty(errorMessages, employment.getEmployerName(),
						"Please enter Employer Name");

				// TO validate EmployerAddress
				if (employment.getEmployerAddress() == null) {

					errorMessages = FERUtil.addErrorIfEmpty(errorMessages, employment.getEmployerAddress(),
							"Please enter Employer Address");

				} else {

					for (LoanAddressDTO address : request.getLoanAddresses()) {
						errorMessages = FERUtil.addErrorIfEmpty(errorMessages, address.getLineOne(),
								"Please enter LineOne");
						errorMessages = FERUtil.addErrorIfEmpty(errorMessages, address.getCity(), "Please enter City");
						errorMessages = FERUtil.addErrorIfEmpty(errorMessages, address.getCountry(),
								"Please enter Country");
						errorMessages = FERUtil.addErrorIfEmpty(errorMessages, address.getPincode(),
								"Please enter Pincode");
						errorMessages = FERUtil.addErrorIfEmpty(errorMessages, address.getState(),
								"Please enter State");
						errorMessages = FERUtil.addErrorIfEmpty(errorMessages, address.getAddressType(),
								"Please enter Address Type");
					}

				}
			} else {
				if (employment.getEmploymentStatus() == "O") {
					errorMessages = FERUtil.addErrorIfEmpty(errorMessages, employment.getOthers(),
							"Please enter others");
				}

			}
		}

		// To validate Financial Details input
		if (request.getFinancialDetails() == null) {
			errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getFinancialDetails(),
					"Please enter FinancialDetails");
		} else {
			FinancialDetailsDTO financialDetails = request.getFinancialDetails();
			errorMessages = FERUtil.addErrorIfEmpty(errorMessages, financialDetails.getGrossSalary(),
					"Please enter Gross Salary");
			errorMessages = FERUtil.addErrorIfEmpty(errorMessages, financialDetails.getNetSalary(),
					"Please enter Net Salary");

		}
		return errorMessages;
	}

	@Override
	public Set<String> validateGetapplicantRequest(Integer applicantId) {
		Set<String> errorMessages = new HashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, applicantId, "Please enter valid applicantId");

		return errorMessages;

	}

	@Override
	public Set<String> loanAccountApproveRequest(LoanAccountApproveRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getLoanAccountId(), "Please enter Id");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getStatus(), "Please enter Status");

		return errorMessages;

	}

	@Override
	public Set<String> loanAccountRejectRequest(LoanAccountRejectRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getLoanAccountId(), "Please enter Id");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getStatus(), "Please enter Status");

		return errorMessages;
	}
}
