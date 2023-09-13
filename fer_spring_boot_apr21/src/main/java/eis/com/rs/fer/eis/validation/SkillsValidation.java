package com.rs.fer.eis.validation;

import java.util.Set;

import com.rs.fer.eis.request.SaveSkillsRequest;

public interface SkillsValidation {

	Set<String> validateSaveSkillsRequest(SaveSkillsRequest request);

}
