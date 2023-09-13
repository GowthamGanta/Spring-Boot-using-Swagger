package com.rs.fer.eis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.eis.entity.Experience_Details;
import com.rs.fer.expense.entity.Expense;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience_Details, Integer>  {
	List<Expense> findById(int eid);

}
