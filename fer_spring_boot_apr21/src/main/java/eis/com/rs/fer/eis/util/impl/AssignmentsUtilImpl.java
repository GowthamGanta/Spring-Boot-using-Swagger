package com.rs.fer.eis.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.entity.Role;
import com.rs.fer.eis.mapper.AddAssignmentsRequestMapper;
import com.rs.fer.eis.mapper.DeleteAssignmentsRequestMapper;
import com.rs.fer.eis.mapper.EditAssignmentsRequestMapper;
import com.rs.fer.eis.request.AddAssignmentsRequest;
import com.rs.fer.eis.request.DeleteAssignmentsRequest;
import com.rs.fer.eis.request.EditAssignmentsRequest;
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

	@Override
	public Role loadEditAssignmentsRequestToAssignments(EditAssignmentsRequest request) {

		Role assignments = EditAssignmentsRequestMapper.MAPPER.mapToEditAssignmentsRequest(request);
		assignments.setCreated(DateUtil.getCurrentDate());

		return assignments;
	}

	@Override
	public Role loadDeleteAssignmentsRequestToAssignments(DeleteAssignmentsRequest request) {

		Role assignments = DeleteAssignmentsRequestMapper.MAPPER.mapToDeleteAssignmentsRequest(request);
		assignments.setCreated(DateUtil.getCurrentDate());

		return assignments;
	}

}
