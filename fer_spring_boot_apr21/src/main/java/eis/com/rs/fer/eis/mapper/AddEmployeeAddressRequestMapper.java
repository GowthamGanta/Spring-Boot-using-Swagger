package com.rs.fer.eis.mapper;

import org.mapstruct.factory.Mappers;

import com.rs.fer.eis.entity.EmployeeAddress;
import com.rs.fer.eis.request.AddEmployeeAddressRequest;

public interface AddEmployeeAddressRequestMapper {

	AddEmployeeAddressRequestMapper MAPPER = Mappers.getMapper(AddEmployeeAddressRequestMapper.class);

	EmployeeAddress mapToEmployeeAddress(AddEmployeeAddressRequest request);
}
