package com.rs.fer.eis.validation;

import java.util.Set;

import com.rs.fer.eis.request.DeleteSkillsRequest;
import com.rs.fer.eis.request.EditSkillsRequest;
import com.rs.fer.eis.request.GetSkillsOptionsRequest;
import com.rs.fer.eis.request.GetSkillsRequest;
import com.rs.fer.eis.request.SaveSkillsRequest;

public interface SkillsValidation {

	Set<String> validateSaveSkillsRequest(SaveSkillsRequest request);

	Set<String> validateEditSkillsRequest(EditSkillsRequest request);

	Set<String> validateDeleteSkillsRequest(DeleteSkillsRequest request);

	Set<String> validateGetSkillsRequest(GetSkillsRequest request);

	Set<String> validateGetSkillsOptionsRequest(GetSkillsOptionsRequest request);

}
