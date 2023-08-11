package com.rs.fer.ipl.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.ipl.entity.IPLMatch;
import com.rs.fer.ipl.repository.MatchRepository;
import com.rs.fer.ipl.repository.TeamRepository;
import com.rs.fer.ipl.request.EditMatchRequest;
import com.rs.fer.ipl.request.SaveMatchRequest;
import com.rs.fer.ipl.response.EditMatchResponse;
import com.rs.fer.ipl.response.GetMatchResponse;
import com.rs.fer.ipl.response.GetMatchesResponse;
import com.rs.fer.ipl.response.SaveMatchResponse;
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
		List<IPLMatch> matches = matchRepository.findByMatchNumber(request.getMatchNumber());

		if (!CollectionUtils.isEmpty(matches)) {

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

	@Override
	public GetMatchesResponse getMatches() {
		GetMatchesResponse response = null;

		List<IPLMatch> matchobj = matchRepository.findAll();

		if (!matchobj.isEmpty()) {

			response = new GetMatchesResponse(HttpStatus.OK, "000", "Fetched Matches  succesfully", null);
			response.setIplmatches(matchobj);

		} else {

			response = new GetMatchesResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Fetching matches is failed",
					null);

		}

		return response;
	}

	@Override
	public GetMatchResponse getMatch(Integer matchId) {

		GetMatchResponse response = null;

		// To get the Applicant based on userId
		Optional<IPLMatch> matchObj = matchRepository.findById(matchId);

		if (matchObj.isPresent()) {

			// If Applicant is present
			response = new GetMatchResponse(HttpStatus.OK, "000", "getmatch is succesfull ", null);
			response.setIplmatch(matchObj.get());

		} else {
			// IfApplicant not present
			response = new GetMatchResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "getMatch is not found", null);

		}

		return response;
	}

	@Override
	public EditMatchResponse editMatch(EditMatchRequest request) {
		EditMatchResponse response = null;

		// Team is present or not check
		List<IPLMatch> matchObj = matchRepository.findByMatchNumber(request.getMatchNumber());

		List<IPLMatch> matches = matchRepository.findByMatchNumber(request.getMatchNumber());

		/*
		 * if (!CollectionUtils.isEmpty(matches)) {
		 * 
		 * // Team already present given Name or Not response = new
		 * EditMatchResponse(HttpStatus.PRECONDITION_FAILED, "001",
		 * "match already find with given matchnumber", null);
		 * 
		 * return response; }
		 * 
		 * List<IPLMatch> match =
		 * matchRepository.findByMatchNumber(request.getMatchNumber());
		 * 
		 * if (!CollectionUtils.isEmpty(match)) {
		 * 
		 * // Team already present given Name or Not response = new
		 * EditMatchResponse(HttpStatus.PRECONDITION_FAILED, "001",
		 * "Match already find with given matchnumber", null);
		 * 
		 * return response; }
		 */

		if (!matchObj.isEmpty()) {

			// load vo to bean
			IPLMatch iplmatch = matchUtil.loadEditMatchRequestToMatch(request);

			// save bean to database
			iplmatch = matchRepository.save(iplmatch);

			// load response
			// success
			response = new EditMatchResponse(HttpStatus.OK, "000", "Team edited successfully", null);
			response.setMatchId(iplmatch);
		} else {
			// failure
			response = new EditMatchResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Team editing failed", null);

		}

		return response;

	}
}