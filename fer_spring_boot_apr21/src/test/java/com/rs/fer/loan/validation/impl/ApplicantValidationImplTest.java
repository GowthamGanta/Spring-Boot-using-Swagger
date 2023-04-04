package com.rs.fer.loan.validation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

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

}
