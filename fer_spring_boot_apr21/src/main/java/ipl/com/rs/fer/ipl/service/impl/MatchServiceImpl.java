package com.rs.fer.ipl.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.ipl.entity.IPLMatch;
import com.rs.fer.ipl.entity.Team;
import com.rs.fer.ipl.repository.MatchRepository;
import com.rs.fer.ipl.repository.TeamRepository;
import com.rs.fer.ipl.request.SaveMatchRequest;
import com.rs.fer.ipl.response.SaveMatchResponse;
import com.rs.fer.ipl.response.SaveTeamResponse;
import com.rs.fer.ipl.service.MatchService;
import com.rs.fer.ipl.util.MatchUtil;
@Service
public class MatchServiceImpl implements MatchService {
@Autowired
MatchUtil matchUtil;
@Autowired
MatchRepository matchRepository;
@Autowired
TeamRepository teamRepository;

	@Override
	public SaveMatchResponse saveMatch(SaveMatchRequest request) {

		SaveMatchResponse response = null;
	List<IPLMatch> matches=matchRepository.findByMatchNumber(request.getMatchNumber());
		
	if(!CollectionUtils.isEmpty(matches)) {
		
		response = new SaveMatchResponse(HttpStatus.PRECONDITION_FAILED, "001",
				"Match is already found with give Match Number ", null);
		
		return response;

	}
	IPLMatch match = matchUtil.loadSaveMatchRequestToMatch(request);
	match = matchRepository.save(match);

	// load response
	if (match.getMatchNumber() > 0) {
		// success
		response = new SaveMatchResponse(HttpStatus.OK, "000", "Match is succesfully saved", null);
		response.setMatch(match);
	} else {
		// failure
		response = new SaveMatchResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Match saved is failed", null);
	}

	return response;

}
}