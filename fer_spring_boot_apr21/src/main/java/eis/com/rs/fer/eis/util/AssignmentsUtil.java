package com.rs.fer.eis.util;

import com.rs.fer.eis.entity.Role;
import com.rs.fer.eis.request.AddAssignmentsRequest;


public interface AssignmentsUtil {
	
	 Role loadAddAssignmentsRequestToAssignments(AddAssignmentsRequest request);
		


}
