package com.rs.fer.user.entity;

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
@Table

public class Address {

	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	
	@Column
	private String lineone;
	
	@Column
	private String linetwo;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String pincode;
	
	@Column
	private String country;

	@Column
	private String created;
	
	@Column
	private String updated;

	public Address() {

	}

	public Address(String lineone, String linetwo, String city, String state, String pincode, String country,String created) {

		this.lineone = lineone;
		this.linetwo = linetwo;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
		this.created = created;
	}

}
