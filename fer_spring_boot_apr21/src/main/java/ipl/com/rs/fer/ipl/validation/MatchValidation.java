package com.rs.fer.ipl.validation;

import java.util.Set;

import com.rs.fer.ipl.request.SaveMatchRequest;

public interface MatchValidation {
  
	
	Set<String> validateSaveMatchRequest(SaveMatchRequest request);
	Set<String> validateGetMatchRequest(Integer matchId);

}
