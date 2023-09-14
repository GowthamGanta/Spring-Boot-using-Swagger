package com.rs.fer.eis.mapper;

import org.mapstruct.factory.Mappers;

import com.rs.fer.eis.entity.Role;
import com.rs.fer.eis.request.DeleteAssignmentsRequest;


public interface DeleteAssignmentsRequestMapper {

	DeleteAssignmentsRequestMapper  MAPPER  = Mappers.getMapper(DeleteAssignmentsRequestMapper.class) ;
	
	Role mapToDeleteAssignmentsRequest(DeleteAssignmentsRequest request);
	

}
