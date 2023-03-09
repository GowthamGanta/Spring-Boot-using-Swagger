package com.rs.fer.participant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.participant.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

}
