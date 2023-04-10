package com.rs.fer.ipl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.ipl.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

	List<Team> findByTeamId(int teamId);

}