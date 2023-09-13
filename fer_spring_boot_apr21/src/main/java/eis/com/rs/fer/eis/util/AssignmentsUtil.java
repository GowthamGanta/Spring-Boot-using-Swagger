package com.rs.fer.eis.util;

import com.rs.fer.eis.entity.EmployeeRoleAssignments;
import com.rs.fer.eis.request.AddAssignmentsRequest;


public interface AssignmentsUtil {
	
	 EmployeeRoleAssignments loadAddAssignmentsRequestToAssignments(AddAssignmentsRequest request);
		


}
