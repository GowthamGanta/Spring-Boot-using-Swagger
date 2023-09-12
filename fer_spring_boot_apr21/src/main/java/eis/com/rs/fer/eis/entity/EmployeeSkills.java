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

	public EmployeeSkills() {

	}

	public EmployeeSkills(int id) {
		this.id = id;
	}

}
