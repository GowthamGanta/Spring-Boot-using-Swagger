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
@Table(name = "employee_experience")
public class Experience_Details {
	@Id
	@Column(name = "experience_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String firm;
	private String fromDate;

	private String toDate;
	private String created;
	private String updated;
	
	
	
	

	public Experience_Details() {

	}

	public Experience_Details(int id, String firm, String fromDate, String toDate, String created, String updated) {

		this.id = id;
		this.firm = firm;
		this.fromDate = fromDate;

		this.toDate = toDate;
		this.created = created;
		this.updated = updated;
	}

}
