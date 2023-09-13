package com.rs.fer.eis.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

	private String startDate;
	private String endDate;

	private String created;
	private String updated;

	// One to many Employee Role Assignments
	@OneToOne(cascade = CascadeType.ALL, targetEntity = Role.class)
	@JoinColumn(name = "r_id", referencedColumnName = "roleid")
	private Role role;

	public EmployeeRole() {

	}

	public EmployeeRole(int id, String created, String updated) {
		this.id = id;
		this.created = created;
		this.updated = updated;
	}

	public Object getAssignments() {
		// TODO Auto-generated method stub
		return null;
	}

}
