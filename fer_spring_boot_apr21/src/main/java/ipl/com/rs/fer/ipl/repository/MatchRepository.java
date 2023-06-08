package com.rs.fer.ipl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.ipl.entity.IPLMatch;

@Repository

public interface MatchRepository extends JpaRepository<IPLMatch, Integer> {
	List<IPLMatch> findByMatchNumber(int matchNumber);

	List<IPLMatch> findByMatchId(int matchId);

}
