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
@Table(name = "skills")

public class Skills {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String name;
	private String created;
	private String updated;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = EmployeeSkills.class)
	@JoinColumn(name = "skill_id", referencedColumnName = "id")
	private Set<EmployeeSkills> employeeSkills;

	public Skills() {

	}

	public Skills(int id, String name, String created, String updated) {

		this.id = id;
		this.name = name;
		this.created = created;
		this.updated = updated;
	}

}
