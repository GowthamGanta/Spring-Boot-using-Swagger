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
public class Venue {

	@Id
	@Column(name = "venue_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int venueId;

	

	@Column
	private String stadiumName;

	@Column
	private String city;


	public Venue() {

	}

	public Venue(String stadiumName, String city) {
		this.stadiumName = stadiumName;
		this.city = city;

	}

}