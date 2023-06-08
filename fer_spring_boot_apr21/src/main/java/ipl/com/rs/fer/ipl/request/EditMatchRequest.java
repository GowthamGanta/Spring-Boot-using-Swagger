package com.rs.fer.ipl.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditMatchRequest {

	private int matchId;
	private int matchNumber;
	private String matchDay;
	private String teamOne;
	private String teamTwo;
	private String venue;
	private String date;
	private String startTime;
	private String endTime;
	private String umpire;
	private String thirdUmpire;
	private String referee;
	private String homeTeam;
	private String awayTeam;

}
