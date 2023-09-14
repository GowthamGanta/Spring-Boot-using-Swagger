package com.rs.fer.eis.mapper;

import org.mapstruct.factory.Mappers;

import com.rs.fer.eis.entity.Role;
import com.rs.fer.eis.request.EditAssignmentsRequest;


public interface EditAssignmentsRequestMapper {

	EditAssignmentsRequestMapper  MAPPER  = Mappers.getMapper(EditAssignmentsRequestMapper.class) ;
	
	Role mapToEditAssignmentsRequest(EditAssignmentsRequest request);
	

}
