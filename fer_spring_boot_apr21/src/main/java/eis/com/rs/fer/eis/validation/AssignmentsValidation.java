package com.rs.fer.eis.validation;

import java.util.Set;

import com.rs.fer.eis.request.AddAssignmentsRequest;
import com.rs.fer.eis.request.DeleteAssignmentsRequest;
import com.rs.fer.eis.request.EditAssignmentsRequest;
import com.rs.fer.eis.request.GetAssignmentsOptionsRequest;
import com.rs.fer.eis.request.GetAssignmentsRequest;


public interface AssignmentsValidation {

	Set<String> validateAddAssignmentsRequest(AddAssignmentsRequest request);	

	Set<String> validateEditAssignmentsRequest(EditAssignmentsRequest request);	

	Set<String> validateDeleteAssignmentsRequest(DeleteAssignmentsRequest request);	

	Set<String> validateGetAssignmentsOptionsRequest(GetAssignmentsOptionsRequest request);	

	Set<String> validateGetAssignmentsRequest(GetAssignmentsRequest request);	

}
