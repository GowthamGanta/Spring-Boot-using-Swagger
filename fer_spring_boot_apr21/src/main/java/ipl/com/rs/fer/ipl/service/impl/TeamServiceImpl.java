package com.rs.fer.ipl.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.ipl.entity.Team;
import com.rs.fer.ipl.repository.TeamRepository;
import com.rs.fer.ipl.request.DeleteTeamRequest;
import com.rs.fer.ipl.request.SaveTeamRequest;
import com.rs.fer.ipl.response.DeleteTeamResponse;
import com.rs.fer.ipl.response.GetTeamResponse;
import com.rs.fer.ipl.response.GetTeamsResponse;
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
	public GetTeamResponse getTeam(Integer teamId) {

		GetTeamResponse response = null;

		// To get the Applicant based on userId
		Optional<Team> teamtObj = teamRepository.findById(teamId);

		if (teamtObj.isPresent()) {

			// If Applicant is present
			response = new GetTeamResponse(HttpStatus.OK, "000", "getTeam is succesfull ", null);
			response.setTeam(teamtObj.get());

		} else {
			// IfApplicant not present
			response = new GetTeamResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "getTeam is not found", null);

		}

		return response;

	}

	@Override
	public DeleteTeamResponse deleteTeam(DeleteTeamRequest request) {
		DeleteTeamResponse response = null;
		Optional<Team> teamobj = teamRepository.findById(request.getTeamId());

		if (!teamobj.isPresent()) {
			response = new DeleteTeamResponse(HttpStatus.OK, "002", "TeamId not found", null);
		} else {
			Team team = teamobj.get();

			int delete = team.getTeamId();

			teamRepository.deleteById(delete);

			response = new DeleteTeamResponse(HttpStatus.OK, "000", " TeamId deleted Successfully", null);
		}
		return response;

	}

	@Override
	public GetTeamsResponse getTeams() {
		GetTeamsResponse response = null;

		List<Team> teamObj = teamRepository.findAll();

		if (!teamObj.isEmpty()) {

			response = new GetTeamsResponse(HttpStatus.OK, "000", "Fetched Teams  succesfully", null);
			response.setTeams(teamObj);

		} else {

			response = new GetTeamsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Fetching is failed", null);

		}

		return response;
	}

}
