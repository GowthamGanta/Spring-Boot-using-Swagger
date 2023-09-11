package com.rs.fer.eis.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee_role")
public class EmployeeRole {

	@Id
	@Column(name = "role_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String roleName;

	// One to many Employee Role Assignments
		@OneToMany(cascade = CascadeType.ALL, targetEntity = EmployeeRoleAssignments.class)
		@JoinColumn(name = "roleId", referencedColumnName = "role_Id")
		private Set<EmployeeRoleAssignments> employeeRoleAssignments;

	public EmployeeRole() {

	}

	public EmployeeRole(int id, String roleName) {

		this.id = id;
		this.roleName = roleName;

	}

}
