package com.rs.fer.eis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee_role_assignments")
public class EmployeeRoleAssignments {

	@Id
	@Column(name = "role_assigned_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int roleAssignedId;
	private String assignmentName;
	private String startDate;
	private String endDate;

	public EmployeeRoleAssignments() {

	}

	public EmployeeRoleAssignments(int roleAssignedId, String assignmentName, String startDate, String endDate) {
		this.roleAssignedId = roleAssignedId;
		this.assignmentName = assignmentName;
		this.startDate = startDate;
		this.endDate = endDate;
	}

}
