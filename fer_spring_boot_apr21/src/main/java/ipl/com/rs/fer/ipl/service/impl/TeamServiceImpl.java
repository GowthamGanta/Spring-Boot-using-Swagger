package com.rs.fer.ipl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.ipl.entity.Team;
import com.rs.fer.ipl.repository.TeamRepository;
import com.rs.fer.ipl.request.GetTeamRequest;
import com.rs.fer.ipl.request.SaveTeamRequest;
import com.rs.fer.ipl.response.GetTeamResponse;
import com.rs.fer.ipl.response.SaveTeamResponse;
import com.rs.fer.ipl.service.TeamService;
import com.rs.fer.ipl.util.TeamUtil;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamUtil teamUtil;
	@Autowired
	TeamRepository teamRepository;

	@Override
	public SaveTeamResponse saveTeam(SaveTeamRequest request) {

		SaveTeamResponse response = null;
		List<Team> teams = teamRepository.findByTeamId(request.getTeamId());

		if (!CollectionUtils.isEmpty(teams)) {

			response = new SaveTeamResponse(HttpStatus.PRECONDITION_FAILED, "001",
					"Team is already find with the given TeamId", null);
			return response;
		}

		// load vo to bean
		Team team = teamUtil.loadSaveTeamRequestToTeam(request);

		// save bean to database
		team = teamRepository.save(team);

		// load response
		if (team.getTeamId() > 0) {
			// success
			response = new SaveTeamResponse(HttpStatus.OK, "000", "Team is succesfully saved", null);
			response.setTeam(team);
		} else {
			// failure
			response = new SaveTeamResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Team saved is failed", null);
		}

		return response;
	}

	@Override
	public GetTeamResponse getTeam(GetTeamRequest request) {

		GetTeamResponse response = null;

		List<Team> teamObj = teamRepository.findByTeamId(request.getTeamId());

		if (teamObj.isEmpty()) {

			response = new GetTeamResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "team not found", null);

		} else {
			// failure
			response = new GetTeamResponse(HttpStatus.OK, "000", "team found", null);
			response.setTeam(teamObj.get(request.getTeamId()));

		}

		return response;

	}
}
