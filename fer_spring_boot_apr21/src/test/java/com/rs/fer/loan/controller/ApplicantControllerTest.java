package com.rs.fer.loan.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.rs.fer.loan.request.GetLoanAccountStatusRequest;
import com.rs.fer.loan.request.LoanAccountApproveRequest;
import com.rs.fer.loan.request.LoanAccountRejectRequest;
import com.rs.fer.loan.response.GetLoanAccountStatusResponse;
import com.rs.fer.loan.response.LoanAccountApproveResponse;
import com.rs.fer.loan.response.LoanAccountRejectResponse;
import com.rs.fer.loan.service.ApplicantService;
import com.rs.fer.loan.validation.ApplicantValidation;

@SpringBootTest
public class ApplicantControllerTest {
	@InjectMocks
	private ApplicantController applicantController;

	@Mock
	ApplicantValidation applicantValidation;

	@Mock
	ApplicantService applicantService;

	@Test
	public void testLoanAccountApprove() {

		// mock
		Set<String> errorMessages = new LinkedHashSet<>();

		LoanAccountApproveRequest request = new LoanAccountApproveRequest();
		LoanAccountApproveResponse response = new LoanAccountApproveResponse(HttpStatus.OK, "000", "", null);

		// When
		when(applicantValidation.loanAccountApproveRequest(Mockito.any())).thenReturn(errorMessages);
		when(applicantService.LoanAccountApprove(Mockito.any())).thenReturn(response);

		// Then
		LoanAccountApproveResponse approveresponse = applicantController.LoanAccountApprove(request);

		assertEquals("000", approveresponse.statusCode);

	}

	@Test
	public void testLoanAccountApproveFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter  Valid LoanAccountId");

		LoanAccountApproveRequest request = new LoanAccountApproveRequest();

		// When
		when(applicantValidation.loanAccountApproveRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		LoanAccountApproveResponse response = applicantController.LoanAccountApprove(request);

		assertEquals("999", response.statusCode);
	}

	@Test
	public void testLoanAccountReject() {

		// mock
		Set<String> errorMessages = new LinkedHashSet<>();

		LoanAccountRejectRequest request = new LoanAccountRejectRequest();
		LoanAccountRejectResponse response = new LoanAccountRejectResponse(HttpStatus.OK, "000", "", null);

		// When
		when(applicantValidation.loanAccountRejectRequest(Mockito.any())).thenReturn(errorMessages);
		when(applicantService.LoanAccountReject(Mockito.any())).thenReturn(response);

		// Then
		LoanAccountRejectResponse rejectresponse = applicantController.LoanAccountReject(request);

		assertEquals("000", rejectresponse.statusCode);

	}

	@Test
	public void testLoanAccountRejectFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter  Valid LoanAccountId");

		LoanAccountRejectRequest request = new LoanAccountRejectRequest();

		// When
		when(applicantValidation.loanAccountRejectRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		LoanAccountRejectResponse response = applicantController.LoanAccountReject(request);

		assertEquals("999", response.statusCode);
	}
	private String status;
	@Test
	public void testGetStatus() {

		Set<String> errorMessages = new LinkedHashSet<>();

		GetLoanAccountStatusRequest request = new GetLoanAccountStatusRequest();
		GetLoanAccountStatusResponse response = new GetLoanAccountStatusResponse(HttpStatus.OK, "000", "", null);

		when(applicantValidation.validateGetLoanAccountStatusRequest(Mockito.any())).thenReturn(errorMessages);
		when(applicantService.getLoanAccountStatus(Mockito.any())).thenReturn(response);

		GetLoanAccountStatusResponse getLoanAccountStatusResponse = applicantController.getLoanAccountByStatus(status);

		assertEquals("000", getLoanAccountStatusResponse.statusCode);
	}

	@Test
	public void testGetStatusFailure() {

		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter Status");

		GetLoanAccountStatusRequest request = new GetLoanAccountStatusRequest();

		when(applicantValidation.validateGetLoanAccountStatusRequest(Mockito.any())).thenReturn(errorMessages);

		GetLoanAccountStatusResponse getLoanAccountStatusResponse = applicantController.getLoanAccountByStatus(status);

		assertEquals("999", getLoanAccountStatusResponse.statusCode);
	}

}
