package com.rs.fer.eis.mapper;

import org.mapstruct.factory.Mappers;

import com.rs.fer.eis.entity.EmployeeRoleAssignments;
import com.rs.fer.eis.request.AddAssignmentsRequest;


public interface AddAssignmentsRequestMapper {

	AddAssignmentsRequestMapper  MAPPER  = Mappers.getMapper(AddAssignmentsRequestMapper.class) ;
	
	EmployeeRoleAssignments mapToAddAssignmentsRequest(AddAssignmentsRequest request);
	

}
