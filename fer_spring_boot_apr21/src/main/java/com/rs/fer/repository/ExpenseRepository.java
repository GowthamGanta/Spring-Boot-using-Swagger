package com.rs.fer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

}