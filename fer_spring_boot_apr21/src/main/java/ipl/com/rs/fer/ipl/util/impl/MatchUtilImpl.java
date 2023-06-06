package com.rs.fer.ipl.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.ipl.entity.IPLMatch;
import com.rs.fer.ipl.request.SaveMatchRequest;
import com.rs.fer.ipl.util.MatchUtil;
import com.rs.fer.util.DateUtil;

@Component

public class MatchUtilImpl implements MatchUtil {

	@Override
	public IPLMatch loadSaveMatchRequestToMatch(SaveMatchRequest request) {
		
		IPLMatch match = new IPLMatch();

		match.setMatchNumber(request.getMatchNumber());
		match.setMatchDay(request.getMatchDay());
		match.setTeamOne(request.getTeamOne());
		match.setTeamTwo(request.getTeamTwo());
		match.setVenue(request.getVenue());
		match.setDate(request.getDate());
		match.setStartTime(request.getStartTime());
		match.setEndTime(request.getEndTime());
		match.setUmpire(request.getUmpire());
		match.setThirdUmpire(request.getThirdUmpire());
		match.setReferee(request.getReferee());
		match.setHomeTeam(request.getHomeTeam());
		match.setAwayTeam(request.getAwayTeam());

		return match;
	}

}
