package com.rs.fer.eis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.eis.entity.Department;
import com.rs.fer.eis.request.DeleteDepartmentRequest;

@Mapper
public interface DeleteDepartmentRequestMapper {

	DeleteDepartmentRequestMapper  MAPPER  = Mappers.getMapper(DeleteDepartmentRequestMapper.class) ;
	
	Department mapToDepartment(DeleteDepartmentRequest request);
	
	
}

