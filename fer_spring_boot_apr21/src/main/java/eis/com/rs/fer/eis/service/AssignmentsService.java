package com.rs.fer.eis.service;

import com.rs.fer.eis.request.AddAssignmentsRequest;
import com.rs.fer.eis.request.DeleteAssignmentsRequest;
import com.rs.fer.eis.request.EditAssignmentsRequest;
import com.rs.fer.eis.request.GetAssignmentsOptionsRequest;
import com.rs.fer.eis.request.GetAssignmentsRequest;
import com.rs.fer.eis.response.AddAssignmentsResponse;
import com.rs.fer.eis.response.DeleteAssignmentsResponse;
import com.rs.fer.eis.response.EditAssignmentsResponse;
import com.rs.fer.eis.response.GetAssignmentsOptionsResponse;
import com.rs.fer.eis.response.GetAssignmentsResponse;


public interface AssignmentsService {
	
	 AddAssignmentsResponse addAssignments(AddAssignmentsRequest request);

	 EditAssignmentsResponse editAssignments(EditAssignmentsRequest request);

	 DeleteAssignmentsResponse deleteAssignments(DeleteAssignmentsRequest request);

	 GetAssignmentsOptionsResponse getAssignmentsOptions(GetAssignmentsOptionsRequest request);
	
	 GetAssignmentsResponse getAssignments(GetAssignmentsRequest request);


}
