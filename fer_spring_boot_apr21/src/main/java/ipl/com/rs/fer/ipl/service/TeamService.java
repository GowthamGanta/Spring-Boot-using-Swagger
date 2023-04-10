package com.rs.fer.ipl.service;

import com.rs.fer.ipl.request.DeleteTeamRequest;
import com.rs.fer.ipl.request.SaveTeamRequest;
import com.rs.fer.ipl.response.DeleteTeamResponse;
import com.rs.fer.ipl.response.GetTeamResponse;
import com.rs.fer.ipl.response.SaveTeamResponse;

public interface TeamService {

	SaveTeamResponse saveTeam(SaveTeamRequest request);

	GetTeamResponse getTeam(Integer teamId);

	DeleteTeamResponse deleteTeam(DeleteTeamRequest request);

}
