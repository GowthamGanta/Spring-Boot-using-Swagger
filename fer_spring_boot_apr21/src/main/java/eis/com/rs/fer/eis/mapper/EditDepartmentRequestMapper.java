package com.rs.fer.eis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.eis.entity.Department;
import com.rs.fer.eis.request.EditDepartmentRequest;

@Mapper
public interface EditDepartmentRequestMapper {

	EditDepartmentRequestMapper MAPPER = Mappers.getMapper(EditDepartmentRequestMapper.class);

	Department mapToDepartment(EditDepartmentRequest request);

}


