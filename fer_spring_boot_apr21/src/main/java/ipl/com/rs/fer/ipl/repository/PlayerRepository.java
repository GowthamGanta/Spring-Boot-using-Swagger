package com.rs.fer.ipl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.ipl.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

	List<Player> findByJerseyNumber(String jerseyNumber);
	
	List<Player> findByPlayerId(int playerId);
	
}