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

import com.rs.fer.loan.request.LoanAccountApproveRequest;
import com.rs.fer.loan.request.LoanAccountRejectRequest;
import com.rs.fer.loan.request.SaveApplicantRequest;
import com.rs.fer.loan.response.GetApplicantResponse;
import com.rs.fer.loan.response.GetLoanAccountResponse;
import com.rs.fer.loan.response.GetLoanAccountStatusResponse;
import com.rs.fer.loan.response.LoanAccountApproveResponse;
import com.rs.fer.loan.response.LoanAccountRejectResponse;
import com.rs.fer.loan.response.SaveApplicantResponse;
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


		when(applicantValidation.validateGetLoanAccountStatusRequest(Mockito.any())).thenReturn(errorMessages);

		GetLoanAccountStatusResponse getLoanAccountStatusResponse = applicantController.getLoanAccountByStatus(status);

		assertEquals("999", getLoanAccountStatusResponse.statusCode);
	}

	@Test
	public void testSaveApplicant() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		SaveApplicantRequest request = new SaveApplicantRequest();
		SaveApplicantResponse response = new SaveApplicantResponse(HttpStatus.OK, "000", "", null);

		// when
		when(applicantValidation.validateSaveApplicantRequest(Mockito.any())).thenReturn(errorMessages);
		when(applicantService.SaveApplicant(Mockito.any())).thenReturn(response);

		// Then
		SaveApplicantResponse saveResponse = applicantController.SaveApplicant(request);

		assertEquals("000", saveResponse.statusCode);

	}

	@Test
	public void testSaveApplicantFailure() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter loanAccountId");

		SaveApplicantRequest request = new SaveApplicantRequest();

		// when
		when(applicantValidation.validateSaveApplicantRequest(Mockito.any())).thenReturn(errorMessages);

		// Then

		SaveApplicantResponse response = applicantController.SaveApplicant(request);

		assertEquals("999", response.statusCode);

	}

	@Test
	public void testGetApplicantId() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		GetApplicantResponse response = new GetApplicantResponse(HttpStatus.OK, "000", "", null);

		when(applicantValidation.validateGetApplicantRequest(Mockito.anyInt())).thenReturn(errorMessages);
		when(applicantService.getApplicant(Mockito.anyInt())).thenReturn(response);
		Integer applicantId = 1;
		GetApplicantResponse Response = applicantController.getApplicant(applicantId);

		assertEquals("000", Response.statusCode);

	}

	@Test
	public void testGetApplicantIdFailure() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter applicantId");


		when(applicantValidation.validateGetApplicantRequest(Mockito.anyInt())).thenReturn(errorMessages);
		Integer applicantId = 0;
		GetApplicantResponse Response = applicantController.getApplicant(applicantId);

		assertEquals("999", Response.statusCode);
	}

	@Test
	public void testGetLoanAccountId() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		
		GetLoanAccountResponse response = new GetLoanAccountResponse(HttpStatus.OK, "000", "", null);

		when(applicantValidation.validateGetLoanAccountRequest(Mockito.anyInt())).thenReturn(errorMessages);
		when(applicantService.getLoanAccount(Mockito.anyInt())).thenReturn(response);
		Integer loanAccountId = 1;
		GetLoanAccountResponse Response = applicantController.getloanAccount(loanAccountId);

		assertEquals("000", Response.statusCode);

	}

	@Test
	public void testGetLoanAccountIdFailure() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter loanAccountId");


		when(applicantValidation.validateGetLoanAccountRequest(Mockito.anyInt())).thenReturn(errorMessages);
		Integer loanAccountId = 0;
		GetLoanAccountResponse Response = applicantController.getloanAccount(loanAccountId);

		assertEquals("999", Response.statusCode);
	}
}
