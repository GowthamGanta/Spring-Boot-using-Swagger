package com.rs.fer.ipl.util;

import com.rs.fer.ipl.entity.Team;
import com.rs.fer.ipl.request.SaveTeamRequest;

public interface TeamUtil {

	Team loadSaveTeamRequestToTeam(SaveTeamRequest request);

}
