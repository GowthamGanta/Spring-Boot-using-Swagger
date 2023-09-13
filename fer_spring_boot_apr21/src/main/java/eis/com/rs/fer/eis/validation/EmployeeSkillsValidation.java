package com.rs.fer.eis.validation;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.rs.fer.eis.request.SaveEmployeeSkillsRequest;
@Service
public interface EmployeeSkillsValidation {

	Set<String> validateSaveEmployeeSkillsRequest(SaveEmployeeSkillsRequest request);

}
