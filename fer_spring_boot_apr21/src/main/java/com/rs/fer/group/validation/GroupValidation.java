package com.rs.fer.group.validation;

import java.util.Set;

import com.rs.fer.group.request.GetGroupRequest;
import com.rs.fer.group.request.SaveGroupRequest;

public interface GroupValidation {

	Set<String> validateSaveGroupRequest(SaveGroupRequest request);

	Set<String> validateGetGroupRequest(GetGroupRequest request);

}
