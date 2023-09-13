package com.rs.fer.eis.mapper;

import org.mapstruct.factory.Mappers;

import com.rs.fer.eis.entity.EmployeeAddress;
import com.rs.fer.eis.request.EditEmployeeAddressRequest;

public interface EditEmployeeAddressRequestMapper {

	EditEmployeeAddressRequestMapper MAPPER = Mappers.getMapper(EditEmployeeAddressRequestMapper.class);

	EmployeeAddress mapToEmployeeAddress(EditEmployeeAddressRequest request, EmployeeAddress employeeAddress);

}
