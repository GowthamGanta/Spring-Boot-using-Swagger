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
public class Educational_Details {
	@Id
	@Column(name = "education_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private String yearOfPassing;
	private String university;

	public Educational_Details() {

	}

	public Educational_Details(int id, String type, String yearOfPassing, String university) {
		this.id = id;
		this.type = type;
		this.yearOfPassing = yearOfPassing;
		this.university = university;
	}

}
