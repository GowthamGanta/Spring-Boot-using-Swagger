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
@Table(name = "role")
public class Role {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;

	private String startDate;
	private String endDate;

	private String created;
	private String updated;
	
	@Column(name="roleid")
	private String roleid;
	
	public Role() {

	}

	public Role(int id, String name, String startDate, String endDate,
			String created, String updated) {

		this.id = id;
		this.name = name;
		this.startDate = startDate;

		this.endDate = endDate;
		this.created = created;
		this.updated = updated;
	}

}
