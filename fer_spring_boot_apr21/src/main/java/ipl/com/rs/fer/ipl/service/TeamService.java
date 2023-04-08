package com.rs.fer.ipl.service;

import com.rs.fer.ipl.request.GetTeamRequest;
import com.rs.fer.ipl.request.SaveTeamRequest;
import com.rs.fer.ipl.response.GetTeamResponse;
import com.rs.fer.ipl.response.SaveTeamResponse;

public interface TeamService {

	SaveTeamResponse saveTeam(SaveTeamRequest request);

	GetTeamResponse getTeam(GetTeamRequest request);

}
