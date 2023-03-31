package com.rs.fer.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.fer.loan.entity.Applicant;
import com.rs.fer.loan.entity.LoanAccount;

public interface LoanAccountRepository extends JpaRepository<LoanAccount, Integer> {


}
