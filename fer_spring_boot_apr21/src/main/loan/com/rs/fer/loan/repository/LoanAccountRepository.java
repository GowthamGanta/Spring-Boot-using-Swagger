package com.rs.fer.loan.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.fer.loan.entity.LoanAccount;

public interface LoanAccountRepository extends JpaRepository<LoanAccount, Integer> {

	
	Set<LoanAccount> findByStatus(String status);
}
