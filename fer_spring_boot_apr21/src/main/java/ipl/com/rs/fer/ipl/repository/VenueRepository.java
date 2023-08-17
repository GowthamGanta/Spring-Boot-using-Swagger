package com.rs.fer.ipl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.ipl.entity.Venue;


@Repository

public interface VenueRepository extends JpaRepository<Venue, Integer> {
	List<Venue> findByStadiumName(String stadiumName);

	

}
