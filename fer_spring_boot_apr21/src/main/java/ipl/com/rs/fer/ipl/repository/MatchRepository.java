package com.rs.fer.ipl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.ipl.entity.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
	List<Match> findByMatchNumber(int matchNumber);

}
