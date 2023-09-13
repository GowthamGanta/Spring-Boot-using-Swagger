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
@Table(name = "employee_skills")
public class EmployeeSkills {

	@Id
	@Column(name = "employeeSkill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String created;
	private String updated;
	private int skill_id;
	
	@Column(name="employee_id")
	private int employeeId;

	public EmployeeSkills() {

	}

	public EmployeeSkills(int id, String created, String updated,int skill_id) {

		this.id = id;
		this.created = created;
		this.updated = updated;
		this.skill_id=skill_id;
	}

}
