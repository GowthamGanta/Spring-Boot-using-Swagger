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
@Table(name = "employee_address")
public class EmployeeAddress {

	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String lineOne;
	private String lineTwo;
	private String city;

	private String state;
	private String pinCode;
	private String country;

	private String addressType;
	private String created;
	private String updated;
	
	@Column(name="eid")
	private int employeeId;

	public EmployeeAddress() {

	}

	public EmployeeAddress(int id, String lineOne, String lineTwo, String city, String state, String pinCode,
			String country, String addressType, String created, String updated) {

		this.id = id;
		this.lineOne = lineOne;
		this.lineTwo = lineTwo;

		this.city = city;
		this.state = state;
		this.pinCode = pinCode;

		this.country = country;
		this.addressType = addressType;
		this.created = created;
		this.updated = updated;
	}

}
