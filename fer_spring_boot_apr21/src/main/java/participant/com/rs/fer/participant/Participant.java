package com.rs.fer.participant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Participant {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="group_id")
	private int groupId;
	
	@Column
	private int participantId;

	public Participant() {

	}

	public Participant(int groupId, int participantId) {

		this.groupId = groupId;
		this.participantId = participantId;

	}
}
