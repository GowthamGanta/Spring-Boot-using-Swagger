package com.rs.fer.eis.mapper;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.request.AddEmployeeRequest;

@Generated(
	    value = "org.mapstruct.ap.MappingProcessor",
	    date = "2023-04-18T12:16:17+0530",
	    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)"
	)
@Component
public class AddEmployeeRequestMapperImpl implements AddEmployeeRequestMapper{

	@Override
	public Employee mapToEmployee(AddEmployeeRequest request) {

		if(request == null) {
			return null;
		}
		
		Employee employee = new Employee();
		
		employee.setFirstName(request.getFirstName());
		employee.setMiddleName(request.getMiddleName());
		employee.setLastName(request.getLastName());
		employee.setDateOfBirth(request.getDateOfBirth());
		employee.setGender(request.getGender());
		employee.setEmail(request.getEmail());
		employee.setMobile(request.getMobile());
		employee.setSalary(request.getSalary());
		
		return employee;
	}

}
