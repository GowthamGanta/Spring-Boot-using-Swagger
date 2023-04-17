package com.rs.fer.ipl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table
public class Player {

	@Id
	@Column(name = "player_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;

	@Column
	private String firstName;

	@Column
	private String middleName;

	@Column
	private String lastName;

	@Column
	private char gender;

	@Column
	private String dob;

	@Column
	private String role;

	@Column
	private String specilization;

	@Column
	private String jerseyNumber;

	@Column
	private String created;

	@Column
	private String updated;

	@Column(name = "t_id")
	private Integer teamId;

	public Player() {

	}

	public Player(String firstName, String middleName, String lastName, char gender, String dob, String role,
			String specilization, String jerseyNumber) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.role = role;
		this.specilization = specilization;
		this.jerseyNumber = jerseyNumber;

	}

}