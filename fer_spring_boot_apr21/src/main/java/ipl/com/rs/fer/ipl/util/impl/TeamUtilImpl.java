package com.rs.fer.ipl.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.ipl.entity.Team;
import com.rs.fer.ipl.request.EditTeamRequest;
import com.rs.fer.ipl.request.SaveTeamRequest;
import com.rs.fer.ipl.util.TeamUtil;
import com.rs.fer.util.DateUtil;

@Component
public class TeamUtilImpl implements TeamUtil {

	@Override
	public Team loadSaveTeamRequestToTeam(SaveTeamRequest request) {

		Team team = new Team();

		team.setName(request.getName());

		team.setCreated(DateUtil.getCurrentDate());
		team.setUpdated(DateUtil.getCurrentDate());

		return team;
	}

	@Override
	public Team loadEditTeamRequestToTeam(EditTeamRequest request) {

		Team team = new Team();

		team.setTeamId(request.getTeamId());
		team.setName(request.getName());

		team.setCreated(DateUtil.getCurrentDate());
		team.setUpdated(DateUtil.getCurrentDate());

		return team;
	}
}