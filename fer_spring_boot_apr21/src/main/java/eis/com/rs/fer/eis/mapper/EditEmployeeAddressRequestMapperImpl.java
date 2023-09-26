package com.rs.fer.eis.mapper;

import javax.annotation.Generated;

import com.rs.fer.eis.entity.EmployeeAddress;
import com.rs.fer.eis.request.EditEmployeeAddressRequest;

@Generated(
		value = "org.mapstruct.ap.MappingProcessor", 
		date = "2023-04-19T07:34:40+0530", 
		comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)"
		)
public class EditEmployeeAddressRequestMapperImpl implements EditEmployeeAddressRequestMapper {

	@Override
	public EmployeeAddress mapToEmployeeAddress(EditEmployeeAddressRequest request, EmployeeAddress employeeAddress) {

		if (request == null) {
			return null;
		}

		employeeAddress.setId(request.getId());
		employeeAddress.setLineOne(request.getLineOne());
		employeeAddress.setLineTwo(request.getLineTwo());
		employeeAddress.setCity(request.getCity());
		employeeAddress.setPinCode(request.getPinCode());

		employeeAddress.setState(request.getState());
		employeeAddress.setCountry(request.getCountry());
		employeeAddress.setAddressType(request.getAddressType());

		return employeeAddress;
	}

}