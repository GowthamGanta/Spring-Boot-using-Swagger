package com.rs.fer.eis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.eis.entity.Department;
import com.rs.fer.eis.request.AddDepartmentRequest;

@Mapper
public interface AddDepartmentRequestMapper {

	AddDepartmentRequestMapper  MAPPER  = Mappers.getMapper(AddDepartmentRequestMapper.class) ;
	
	Department mapToDepartment(AddDepartmentRequest request);
	
}

