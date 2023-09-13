package com.rs.fer.eis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.request.EditEmployeeRequest;

@Mapper(componentModel = "spring")
public interface EditEmployeeRequestMapper {

	EditEmployeeRequestMapper MAPPER = Mappers.getMapper(EditEmployeeRequestMapper.class);
	
	Employee mapToEmployee(EditEmployeeRequest request, Employee employee);

	Employee mapToEmployee(EditEmployeeRequest request);
}

