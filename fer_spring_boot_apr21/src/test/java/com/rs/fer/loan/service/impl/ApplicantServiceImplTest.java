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
import com.rs.fer.loan.request.GetLoanAccountRequest;
import com.rs.fer.loan.response.GetLoanAccountResponse;

@SpringBootTest
public class ApplicantServiceImplTest<LoanAccountRequest> {

	@InjectMocks
	private ApplicantServiceImpl applicantServiceImpl;

	@Mock
	LoanAccountRepository loanAccountRepository;

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
}