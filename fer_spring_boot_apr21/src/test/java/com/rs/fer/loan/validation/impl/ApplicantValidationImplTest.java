package com.rs.fer.loan.validation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.loan.request.GetLoanAccountStatusRequest;
import com.rs.fer.loan.request.LoanAccountApproveRequest;
import com.rs.fer.loan.request.LoanAccountRejectRequest;

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

		GetLoanAccountStatusRequest request = new GetLoanAccountStatusRequest();

		String P = null;
		// request.setStatus(P);

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

}
