package com.rs.fer.ipl.service;

import com.rs.fer.ipl.request.SaveMatchRequest;
import com.rs.fer.ipl.response.GetMatchResponse;
import com.rs.fer.ipl.response.GetMatchesResponse;
import com.rs.fer.ipl.response.SaveMatchResponse;

public interface MatchService {

	SaveMatchResponse saveMatch(SaveMatchRequest request);

	GetMatchesResponse getMatches();
	GetMatchResponse getMatch();
}