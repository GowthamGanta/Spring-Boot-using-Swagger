package com.rs.fer.ipl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Service;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table
public class IPLMatch {

	@Id
	@Column(name = "match_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int matchId;

	@Column
	private int matchNumber;

	@Column
	private String matchDay;

	@Column
	private String teamOne;

	@Column
	private String teamTwo;

	@Column
	private String venue;

	@Column
	private String date;

	@Column
	private String startTime;

	@Column
	private String endTime;

	@Column
	private String umpire;

	@Column
	private String thirdUmpire;

	@Column
	private String referee;

	@Column
	private String homeTeam;

	@Column
	private String awayTeam;

	public IPLMatch() {

	}

	public IPLMatch(int matchNumber, String matchDay, String teamOne, String teamTwo, String venue, String date,
			String startTime, String endTime, String umpire, String thirdUmpire, String referee, String homeTeam,
			String awayTeam) {
		this.matchNumber = matchNumber;
		this.matchDay = matchDay;
		this.teamOne = teamOne;
		this.teamTwo = teamTwo;
		this.venue = venue;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.umpire = umpire;
		this.thirdUmpire = thirdUmpire;
		this.referee = referee;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;

	
	}
}