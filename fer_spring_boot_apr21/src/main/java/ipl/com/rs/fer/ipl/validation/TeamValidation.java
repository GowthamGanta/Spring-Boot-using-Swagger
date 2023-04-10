package com.rs.fer.ipl.validation;

import java.util.Set;

import com.rs.fer.ipl.request.SaveTeamRequest;

public interface TeamValidation {

	Set<String> validateSaveTeamRequest(SaveTeamRequest request);

	Set<String> validateGetTeamRequest(Integer teamId);

}
