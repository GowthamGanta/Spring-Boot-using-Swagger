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

	private String created;
	private String updated;

	// One to many Employee Role Assignments
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Role.class)
	@JoinColumn(name = "roleid", referencedColumnName = "role_Id")
	private Set<Role> roles;

	public EmployeeRole() {

	}

	public EmployeeRole(int id, String roleName, String created, String updated) {
		this.id = id;
		this.roleName = roleName;
		this.created = created;
		this.updated = updated;
	}

	public Object getAssignments() {
		// TODO Auto-generated method stub
		return null;
	}

}
