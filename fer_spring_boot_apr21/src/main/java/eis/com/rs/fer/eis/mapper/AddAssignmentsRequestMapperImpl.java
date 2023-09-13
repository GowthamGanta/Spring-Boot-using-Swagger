package com.rs.fer.eis.mapper;

import javax.annotation.Generated;

import com.rs.fer.eis.entity.Role;
import com.rs.fer.eis.request.AddAssignmentsRequest;

@Generated(value = "org.mapstruct.ap.MappingProcessor", date = "2023-09-12T07:34:40+0530", comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)")
public class AddAssignmentsRequestMapperImpl implements AddAssignmentsRequestMapper {

	@Override
	public Role mapToAddAssignmentsRequest(AddAssignmentsRequest request) {
		if (request == null) {
			return null;
		}
		Role assignments = new Role();

		assignments.setName(request.getAssignmentName());
		assignments.setId(request.getRoleId());

		return assignments;

	}

}
