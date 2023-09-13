package com.rs.fer.eis.util.impl;


import org.springframework.stereotype.Component;

import com.rs.fer.eis.entity.Role;
import com.rs.fer.eis.mapper.AddAssignmentsRequestMapper;
import com.rs.fer.eis.request.AddAssignmentsRequest;
import com.rs.fer.eis.util.AssignmentsUtil;
import com.rs.fer.util.DateUtil;

@Component
public class AssignmentsUtilImpl implements AssignmentsUtil {
	
	@Override
	public Role loadAddAssignmentsRequestToAssignments(AddAssignmentsRequest request) {

		Role assignments = AddAssignmentsRequestMapper.MAPPER.mapToAddAssignmentsRequest(request);
		assignments.setCreated(DateUtil.getCurrentDate());

		return assignments;
	}

}
