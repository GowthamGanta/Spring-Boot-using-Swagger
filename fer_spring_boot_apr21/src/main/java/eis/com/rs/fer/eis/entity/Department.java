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
@Table(name = "department")
public class Department {

	@Id
	@Column(name = "department_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String departmentName;
	private String created;
	private String updated;

	public Department() {

	}

	public Department(int id, String departmentName, String created, String updated) {

		this.id = id;
		this.departmentName = departmentName;
		this.created = created;
		this.updated = updated;
	}

}
