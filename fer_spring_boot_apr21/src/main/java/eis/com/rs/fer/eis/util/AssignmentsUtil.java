package com.rs.fer.eis.util;

import com.rs.fer.eis.entity.Role;
import com.rs.fer.eis.request.AddAssignmentsRequest;
import com.rs.fer.eis.request.DeleteAssignmentsRequest;
import com.rs.fer.eis.request.EditAssignmentsRequest;


public interface AssignmentsUtil {
	
	 Role loadAddAssignmentsRequestToAssignments(AddAssignmentsRequest request);

	 Role loadEditAssignmentsRequestToAssignments(EditAssignmentsRequest request);
	
	 Role loadDeleteAssignmentsRequestToAssignments(DeleteAssignmentsRequest request);

	 //Role loadDeleteAssignmentsRequestToAssignments(GetAssignmentsOptionsRequest request);



}
