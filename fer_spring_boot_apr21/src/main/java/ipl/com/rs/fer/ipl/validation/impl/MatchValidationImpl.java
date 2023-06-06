package com.rs.fer.ipl.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import com.rs.fer.ipl.request.SaveMatchRequest;
import com.rs.fer.ipl.validation.MatchValidation;
import com.rs.fer.util.FERUtil;

public class MatchValidationImpl implements MatchValidation {

	@Override
	public Set<String> validateSaveMatchRequest(SaveMatchRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getMatchNumber(), "Please enter matchNumber");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getMatchDay(), "Please enter matchDay");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getTeamOne(), "Please enter teamOne");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getTeamTwo(), "Please enter teamTwo");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getVenue(), "Please enter venue");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getDate(), "Please enter date");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getStartTime(), "Please enter startTime");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEndTime(), "Please enter endTime");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUmpire(), "Please enter umpire");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getThirdUmpire(), "Please enter thirdUmpire");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getReferee(), "Please enter referee");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getHomeTeam(), "Please enter homeTeam");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getAwayTeam(), "Please enter awayTeam");
		return errorMessages;
	}

}
