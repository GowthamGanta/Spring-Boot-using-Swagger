package com.rs.fer.eis.service;

import com.rs.fer.eis.request.AddAssignmentsRequest;
import com.rs.fer.eis.response.AddAssignmentsResponse;


public interface AssignmentsService {
	
	 AddAssignmentsResponse addAssignments(AddAssignmentsRequest request);

}
