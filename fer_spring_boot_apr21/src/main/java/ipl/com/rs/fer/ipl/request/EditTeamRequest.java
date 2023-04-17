package com.rs.fer.ipl.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditTeamRequest {

	private int teamId;
	private String name;
	private String teamCode;
	private String created;
	private String updated;

}