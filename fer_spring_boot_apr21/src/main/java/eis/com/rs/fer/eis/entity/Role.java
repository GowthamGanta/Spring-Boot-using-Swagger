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
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String created;
	private String updated;

	public Role() {

	}

	public Role(int id, String name, String startDate, String endDate,
			String created, String updated) {

		this.id = id;
		this.name = name;
		this.created = created;
		this.updated = updated;
	}

}
