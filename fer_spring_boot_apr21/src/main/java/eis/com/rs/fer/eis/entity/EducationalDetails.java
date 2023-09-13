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
@Table(name = "employee_education")
public class EducationalDetails {

	@Id
	@Column(name = "education_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private String yearOfPassing;

	private String university;
	private String created;
	private String updated;

	public EducationalDetails() {

	}

	public EducationalDetails(int id, String type, String yearOfPassing, String university, String created,
			String updated) {

		this.id = id;
		this.type = type;
		this.yearOfPassing = yearOfPassing;

		this.university = university;
		this.created = created;
		this.updated = updated;
	}

}
