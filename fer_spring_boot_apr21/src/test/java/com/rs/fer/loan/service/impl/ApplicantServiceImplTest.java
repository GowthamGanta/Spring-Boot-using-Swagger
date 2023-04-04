package com.rs.fer.loan.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.loan.entity.LoanAccount;
import com.rs.fer.loan.repository.LoanAccountRepository;
import com.rs.fer.loan.request.LoanAccountApproveRequest;
import com.rs.fer.loan.request.LoanAccountRejectRequest;
import com.rs.fer.loan.response.GetLoanAccountResponse;
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
	ApplicantUtil applicantUtil;

	@Test
	public void testApplicantServiceImpl() {
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
	public <LoanAccountResponse> void testApplicantServiceImplFailure() {
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

}