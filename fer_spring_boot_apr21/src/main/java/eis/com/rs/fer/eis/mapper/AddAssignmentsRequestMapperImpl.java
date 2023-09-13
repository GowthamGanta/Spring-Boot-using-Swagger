package com.rs.fer.eis.mapper;

import javax.annotation.Generated;

import com.rs.fer.eis.entity.EmployeeRoleAssignments;
import com.rs.fer.eis.request.AddAssignmentsRequest;

@Generated(
	    value = "org.mapstruct.ap.MappingProcessor",
	    date = "2023-09-12T07:34:40+0530",
	    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)"
	)
public class AddAssignmentsRequestMapperImpl implements AddAssignmentsRequestMapper {

	@Override
	public EmployeeRoleAssignments mapToAddAssignmentsRequest(AddAssignmentsRequest request) {
		if( request == null ) {
			return null;
		}
		EmployeeRoleAssignments assignments = new EmployeeRoleAssignments ();
		
		assignments.setAssignmentName(request.getAssignmentName());
		assignments.setStartDate(request.getStartDate());
		assignments.setEndDate(request.getEndDate());
		assignments.setRoleId(request.getRoleId());
		
		
		return assignments;
		
	}

}
