package com.rs.fer.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.fer.loan.entity.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {


}
