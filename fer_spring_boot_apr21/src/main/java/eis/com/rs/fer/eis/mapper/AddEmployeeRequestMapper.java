package com.rs.fer.eis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.request.AddEmployeeRequest;

@Mapper(componentModel = "spring")
public interface AddEmployeeRequestMapper {

	AddEmployeeRequestMapper MAPPER = Mappers.getMapper(AddEmployeeRequestMapper.class);
	
	Employee mapToEmployee(AddEmployeeRequest request);
}

