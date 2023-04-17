package com.rs.fer.loan.entity;

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
public class LoanAddress {

	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;

	@Column
	private String lineOne;
	
	@Column
	private String lineTwo;
	
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
	
	@Column
	private String addressType;

	@Column(name = "appl_id", insertable = false)
	private Integer applicantId;

	public LoanAddress() {

	}

	public LoanAddress(String lineOne, String lineTwo, String city, String state, String pincode, String country,
			String addressType) {

		this.lineOne = lineOne;
		this.lineTwo = lineTwo;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;

		this.addressType = addressType;
	}
}
