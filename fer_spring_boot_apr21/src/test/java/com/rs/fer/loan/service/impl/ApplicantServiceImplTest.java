package com.rs.fer.loan.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.loan.entity.Applicant;
import com.rs.fer.loan.entity.LoanAccount;
import com.rs.fer.loan.repository.ApplicantRepository;
import com.rs.fer.loan.repository.LoanAccountRepository;
import com.rs.fer.loan.request.LoanAccountApproveRequest;
import com.rs.fer.loan.request.LoanAccountRejectRequest;
import com.rs.fer.loan.response.GetApplicantResponse;
import com.rs.fer.loan.response.GetLoanAccountResponse;
import com.rs.fer.loan.response.GetLoanAccountStatusResponse;
import com.rs.fer.loan.response.LoanAccountApproveResponse;
import com.rs.fer.loan.response.LoanAccountRejectResponse;
import com.rs.fer.loan.util.ApplicantUtil;

@SpringBootTest
public class ApplicantServiceImplTest {

	@InjectMocks
	private ApplicantServiceImpl applicantServiceImpl;

	@Mock
	LoanAccountRepository loanAccountRepository;

	@Mock
	ApplicantRepository applicantRepository;

	@Mock
	ApplicantUtil applicantUtil;

	@Test
	public void testGetLoanAccountResponse() {
		LoanAccount loanAccount = new LoanAccount();
		loanAccount.setLoanAccountId(1);
		Optional<LoanAccount> loanAccounts = Optional.of(loanAccount);

		when(loanAccountRepository.findById(Mockito.anyInt())).thenReturn(loanAccounts);

		int loanAccountId = 1;

		GetLoanAccountResponse response = applicantServiceImpl.getLoanAccount(loanAccountId);

		// 3.

		assertEquals("000", response.statusCode);

	}

	@Test
	public void testGetLoanAccountResponseFailure() {
		LoanAccount loanAccount = new LoanAccount();
		// loanAccount.setLoanAccountId(1);
		loanAccount.getLoanAccountId();
		Optional<LoanAccount> loanAccounts = Optional.empty();

		when(loanAccountRepository.findById(Mockito.anyInt())).thenReturn(loanAccounts);

		int loanAccountId = 0;
		GetLoanAccountResponse response = applicantServiceImpl.getLoanAccount(loanAccountId);

		// 3.
		assertEquals("002", response.statusCode);

	}

	@Test
	public void testLoanAccountApprove() {

		LoanAccount loanAccount = new LoanAccount();
		loanAccount.setLoanAccountId(2);
		loanAccount.setStatus("A");

		Optional<LoanAccount> loanAccounts = Optional.of(loanAccount);

		when(loanAccountRepository.findById(Mockito.anyInt())).thenReturn(loanAccounts);
		when(loanAccountRepository.save(Mockito.any())).thenReturn(loanAccount);

		LoanAccountApproveRequest request = new LoanAccountApproveRequest();
		request.setLoanAccountId(2);

		LoanAccountApproveResponse response = applicantServiceImpl.LoanAccountApprove(request);
		assertEquals("000", response.statusCode);
	}

	@Test
	public void testLoanAccountsNotPresent() {

		Optional<LoanAccount> loanAccounts = Optional.empty();

		when(loanAccountRepository.findById(Mockito.anyInt())).thenReturn(loanAccounts);

		LoanAccountApproveRequest request = new LoanAccountApproveRequest();
		request.setLoanAccountId(2);

		LoanAccountApproveResponse response = applicantServiceImpl.LoanAccountApprove(request);

		assertEquals("101", response.statusCode);
	}

	@Test
	public void testLoanAccountReject() {

		LoanAccount loanAccount = new LoanAccount();
		loanAccount.setLoanAccountId(1);
		loanAccount.setStatus("R");

		Optional<LoanAccount> loanAccounts = Optional.of(loanAccount);

		when(loanAccountRepository.findById(Mockito.anyInt())).thenReturn(loanAccounts);
		when(loanAccountRepository.save(Mockito.any())).thenReturn(loanAccount);

		LoanAccountRejectRequest request = new LoanAccountRejectRequest();
		request.setLoanAccountId(1);

		LoanAccountRejectResponse response = applicantServiceImpl.LoanAccountReject(request);
		assertEquals("000", response.statusCode);
	}

	@Test
	public void testLoanAccountsNotPresents() {

		Optional<LoanAccount> loanAccounts = Optional.empty();

		when(loanAccountRepository.findById(Mockito.anyInt())).thenReturn(loanAccounts);

		LoanAccountRejectRequest request = new LoanAccountRejectRequest();
		request.setLoanAccountId(1);

		LoanAccountRejectResponse response = applicantServiceImpl.LoanAccountReject(request);

		assertEquals("101", response.statusCode);
	}

	@Test
	public void testGetLoanAccountStatus() {

		LoanAccount loanAccountStatus = new LoanAccount();
		// String P = null;
		loanAccountStatus.setStatus("P");

		Set<LoanAccount> loanAccounts = new HashSet<>();
		loanAccounts.add(loanAccountStatus);

		Set<Applicant> applicant = new HashSet<>();
		Applicant applicants = new Applicant();
		applicant.add(applicants);

		when(loanAccountRepository.findByStatus(Mockito.anyString())).thenReturn(loanAccounts);

		when(applicantRepository.findByLoanAccountId(Mockito.anyInt())).thenReturn(applicant);

		// GetLoanAccountStatusRequest request = new GetLoanAccountStatusRequest();

		GetLoanAccountStatusResponse response = applicantServiceImpl.getLoanAccountStatus("p");
		response.setLoanAccounts(applicant);

		assertEquals("000", response.statusCode);

	}

	@Test
	public void testGetLoanAccountStatusNotFound() {

		LoanAccount loanAccountStatus = new LoanAccount();
		// loanAccountStatus.setStatus("P");
		Set<LoanAccount> loanAccounts = new HashSet<>();
		loanAccounts.add(loanAccountStatus);

		String P = null;

		when(loanAccountRepository.findByStatus(Mockito.anyString())).thenReturn(loanAccounts);

		GetLoanAccountStatusResponse response = applicantServiceImpl.getLoanAccountStatus(P);

		assertEquals("903", response.statusCode);

	}

	@Test
	public void testGetApplicantResponse() {
		Applicant applicant = new Applicant();

		Optional<Applicant> applicantObj = Optional.of(applicant);
		

		when(applicantRepository.findById(Mockito.anyInt())).thenReturn(applicantObj);

		int applicantId = 1;

		GetApplicantResponse response = applicantServiceImpl.getApplicant(applicantId);

		// 3.

		assertEquals("000", response.statusCode);

	}

	@Test
	public void testGetApplicantResponseFailure() {

		Optional<Applicant> applicantObj = Optional.empty();
		

		when(applicantRepository.findById(Mockito.anyInt())).thenReturn(applicantObj);

		int applicantId = 0;

		GetApplicantResponse response = applicantServiceImpl.getApplicant(applicantId);

		// 3.

		assertEquals("002", response.statusCode);

	}
}