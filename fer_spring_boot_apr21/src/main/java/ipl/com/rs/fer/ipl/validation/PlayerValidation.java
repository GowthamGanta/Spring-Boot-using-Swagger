package com.rs.fer.ipl.validation;

import java.util.Set;

import com.rs.fer.ipl.request.SavePlayerRequest;

public interface PlayerValidation {

	Set<String> validateSavePlayerRequest(SavePlayerRequest request);

	Set<String> validateDeletePlayerRequest(int playerId);

	Set<String> validateGetPlayersRequest(Integer teamId);
	
	Set<String> validateGetPlayerRequest(Integer playerId);

}