package com.rs.fer.participant.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.participant.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

	List<Participant> findByGroupId(int groupId);

	Optional<Participant> findByParticipantId(int participantId);
}
