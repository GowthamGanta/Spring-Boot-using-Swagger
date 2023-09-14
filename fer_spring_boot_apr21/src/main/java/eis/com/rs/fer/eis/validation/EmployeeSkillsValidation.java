package com.rs.fer.eis.validation;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.rs.fer.eis.request.DeleteEmployeeSkillsRequest;
import com.rs.fer.eis.request.EditEmployeeSkillsRequest;
import com.rs.fer.eis.request.GetEmployeeSkillsOptionsRequest;
import com.rs.fer.eis.request.GetEmployeeSkillsRequest;
import com.rs.fer.eis.request.SaveEmployeeSkillsRequest;

@Service
public interface EmployeeSkillsValidation {

	Set<String> validateSaveEmployeeSkillsRequest(SaveEmployeeSkillsRequest request);

	Set<String> validateEditEmployeeSkillsRequest(EditEmployeeSkillsRequest request);

	Set<String> validateGetEmployeeSkillsRequest(GetEmployeeSkillsRequest request);

	Set<String> validateDeleteEmployeeSkillsRequest(DeleteEmployeeSkillsRequest request);

	Set<String> validateGetEmployeeSkillsOptionsRequest(GetEmployeeSkillsOptionsRequest request);
}
