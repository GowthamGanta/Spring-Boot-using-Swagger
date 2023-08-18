package com.rs.fer.loan.validation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.loan.request.EmailDTO;
import com.rs.fer.loan.request.EmploymentDTO;
import com.rs.fer.loan.request.FinancialDetailsDTO;
import com.rs.fer.loan.request.GetLoanAccountStatusRequest;
import com.rs.fer.loan.request.KycDTO;
import com.rs.fer.loan.request.LoanAccountApproveRequest;
import com.rs.fer.loan.request.LoanAccountRejectRequest;
import com.rs.fer.loan.request.LoanAddressDTO;
import com.rs.fer.loan.request.MobileDTO;
import com.rs.fer.loan.request.SaveApplicantRequest;

@SpringBootTest
public class ApplicantValidationImplTest {

	@InjectMocks
	private ApplicantValidationImpl applicantValidationImpl;
	@Test
	public void testValidateLoanAccountApprove() {

		LoanAccountApproveRequest request = new LoanAccountApproveRequest();

		request.setLoanAccountId(1);

		Set<String> errorMessages = applicantValidationImpl.loanAccountApproveRequest(request);

		boolean isExpectedEmpty = true;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testLoanAccountApprovefailure() {

		LoanAccountApproveRequest request = new LoanAccountApproveRequest();

		// request.setLoanAccountId(1);

		Set<String> errorMessages = applicantValidationImpl.loanAccountApproveRequest(request);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testValidateLoanAccountReject() {

		LoanAccountRejectRequest request = new LoanAccountRejectRequest();

		request.setLoanAccountId(1);

		Set<String> errorMessages = applicantValidationImpl.loanAccountRejectRequest(request);

		boolean isExpectedEmpty = true;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testLoanAccountRejectfailure() {

		LoanAccountRejectRequest request = new LoanAccountRejectRequest();

		// request.setLoanAccountId(1);

		Set<String> errorMessages = applicantValidationImpl.loanAccountRejectRequest(request);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testvalidateGetLoanAccountStatusRequest() {

		GetLoanAccountStatusRequest request = new GetLoanAccountStatusRequest();

		String P = null;
		request.setStatus(P);

		Set<String> errorMessages = applicantValidationImpl.validateGetLoanAccountStatusRequest(toString());

		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}

	@Test
	public void testvalidateGetLoanAccountStatusRequestFailure() {

		new GetLoanAccountStatusRequest();

		Set<String> errorMessages = applicantValidationImpl.validateGetLoanAccountStatusRequest(toString());

		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}

	@Test
	public void testvalidateGetApplicantRequest() {

		// GetApplicantRequest request = new GetApplicantRequest();
		int applicantId = 1;
		Set<String> errorMessages = applicantValidationImpl.validateGetApplicantRequest(applicantId);
		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}

	@Test
	public void testvalidateGetApplicantRequestFailure() {

		// GetApplicantRequest request = new GetApplicantRequest();
		int applicantId = 0;
		Set<String> errorMessages = applicantValidationImpl.validateGetApplicantRequest(applicantId);
		boolean isExpectedEmpty = false;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}

	@Test
	public void testvalidateGetLoanAccountRequest() {

		// GetApplicantRequest request = new GetApplicantRequest();
		int loanAccountId = 1;
		Set<String> errorMessages = applicantValidationImpl.validateGetLoanAccountRequest(loanAccountId);
		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}

	@Test
	public void testvalidateGetLoanAccountRequestFailure() {

		// GetApplicantRequest request = new GetApplicantRequest();
		int loanAccountId = 0;
		Set<String> errorMessages = applicantValidationImpl.validateGetLoanAccountRequest(loanAccountId);
		boolean isExpectedEmpty = false;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}

	@Test
	public void testvalidEmailFailure() {
		SaveApplicantRequest request = new SaveApplicantRequest();
		Set<String> errorMessages = applicantValidationImpl.validateSaveApplicantRequest(request);
		boolean isExpectedEmpty = false;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
	@Test
	public void testvalidEmail() {
		SaveApplicantRequest request = new SaveApplicantRequest();
		Set<EmailDTO> emailDTOs = new LinkedHashSet<EmailDTO>();
		EmailDTO email = new EmailDTO();
		email.setEmailAddress("rtyu@rs.com");
		emailDTOs.add(email);
		request.setEmails(emailDTOs);
		
		Set<String> errorMessages = applicantValidationImpl.validateSaveApplicantRequest(request);
		
		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
	@Test
	public void testvalidKycFailure() {
		SaveApplicantRequest request = new SaveApplicantRequest();
		Set<String> errorMessages = applicantValidationImpl.validateSaveApplicantRequest(request);
		boolean isExpectedEmpty = false;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
	@Test
	public void testvalidKyc() {
		SaveApplicantRequest request = new SaveApplicantRequest();
		Set<KycDTO> kycDTOs = new LinkedHashSet<KycDTO>();
		KycDTO kycDTO = new KycDTO();
		kycDTO.setDocType("PP");
		kycDTO.setDateOfExpiry("12-09-2025");
		kycDTO.setDateOfIssue("12-09-2024");
		kycDTO.setPlaceOfIssue("Hyd");
		kycDTO.setDocCode("34567");
		kycDTOs.add(kycDTO);
		request.setKyc(kycDTOs);
		
		Set<String> errorMessages = applicantValidationImpl.validateSaveApplicantRequest(request);
		
		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
	@Test
	public void testvalidMobilesFailure() {
		SaveApplicantRequest request = new SaveApplicantRequest();
		Set<String> errorMessages = applicantValidationImpl.validateSaveApplicantRequest(request);
		boolean isExpectedEmpty = false;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
	@Test
	public void testvalidMobiles() {
		SaveApplicantRequest request = new SaveApplicantRequest();
		Set<MobileDTO> mobileDTO = new LinkedHashSet<MobileDTO>();
		MobileDTO mobile = new MobileDTO();
		mobile.setNumber("23456789");
		mobile.setCountryCode(+91);
		mobileDTO.add(mobile);
		request.setMobiles(mobileDTO);
		
		Set<String> errorMessages = applicantValidationImpl.validateSaveApplicantRequest(request);
		
		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
	@Test
	public void testvalidLoanAddressesFailure() {
		SaveApplicantRequest request = new SaveApplicantRequest();
		Set<String> errorMessages = applicantValidationImpl.validateSaveApplicantRequest(request);
		boolean isExpectedEmpty = false;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
	@Test
	public void testvalidLoanAddresses() {
		SaveApplicantRequest request = new SaveApplicantRequest();
		Set<LoanAddressDTO> loanAddressDTO = new LinkedHashSet<LoanAddressDTO>();
		LoanAddressDTO loanAddress = new LoanAddressDTO();
		loanAddress.setLineOne("street");
		loanAddress.setCity("HYF");
		loanAddress.setCountry("IND");
		loanAddress.setPincode("45678");
		loanAddress.setState("TS");
		loanAddress.setAddressType("ERTYU");
		loanAddressDTO.add(loanAddress);
		request.setLoanAddresses(loanAddressDTO);
		
		Set<String> errorMessages = applicantValidationImpl.validateSaveApplicantRequest(request);
		
		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
	@Test
	public void testvalidEmploymentFailure() {
		SaveApplicantRequest request = new SaveApplicantRequest();
		Set<String> errorMessages = applicantValidationImpl.validateSaveApplicantRequest(request);
		boolean isExpectedEmpty = false;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
	
	@Test
	public void testvalidLoanEmployment() {
		SaveApplicantRequest request = new SaveApplicantRequest();
		Set<EmploymentDTO> employmentDTO = new LinkedHashSet<EmploymentDTO>();
		EmploymentDTO employment = new EmploymentDTO();
		employment.setEmployerAddress(null);
		employment.setEmploymentStatus("E");
		employment.setEmployerName("FGHJ");
		employment.setOthers("O");
		employmentDTO.add(employment);
		
		Set<LoanAddressDTO> loanAddressDTO = new LinkedHashSet<LoanAddressDTO>();
		LoanAddressDTO loanAddress = new LoanAddressDTO();
		loanAddress.setLineOne("street");
		loanAddress.setCity("HYF");
		loanAddress.setCountry("IND");
		loanAddress.setPincode("45678");
		loanAddress.setState("TS");
		loanAddress.setAddressType("ERTYU");
		loanAddressDTO.add(loanAddress);
		
		request.getEmployment();

		Set<String> errorMessages = applicantValidationImpl.validateSaveApplicantRequest(request);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
		@Test
		public void testvalidFinantialDetailsFailure() {
			SaveApplicantRequest request = new SaveApplicantRequest();
			Set<String> errorMessages = applicantValidationImpl.validateSaveApplicantRequest(request);
			boolean isExpectedEmpty = false;

			boolean isActualEmpty = errorMessages.isEmpty();

			assertEquals(isExpectedEmpty, isActualEmpty);
		}
		
		
		@Test
		public void testvalidFinantialDetails() {
			SaveApplicantRequest request = new SaveApplicantRequest();
			Set<FinancialDetailsDTO> financialDetailsDTO = new LinkedHashSet<FinancialDetailsDTO>();
			FinancialDetailsDTO financialDetails = new FinancialDetailsDTO();
			financialDetails.setGrossSalary((float) 40000);
			financialDetails.setNetSalary((float) 47000);
			financialDetailsDTO.add(financialDetails);
			
			request.getFinancialDetails();

			Set<String> errorMessages = applicantValidationImpl.validateSaveApplicantRequest(request);

			boolean isExpectedEmpty = false;
			boolean isActualEmpty = errorMessages.isEmpty();

			assertEquals(isExpectedEmpty, isActualEmpty);
		}
	
}
