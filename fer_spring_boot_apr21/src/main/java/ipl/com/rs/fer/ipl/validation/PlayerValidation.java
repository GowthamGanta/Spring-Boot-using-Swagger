package com.rs.fer.ipl.validation;

import java.util.Set;

import com.rs.fer.ipl.request.SavePlayerRequest;

public interface PlayerValidation {

	Set<String> validateSavePlayerRequest(SavePlayerRequest request);

}