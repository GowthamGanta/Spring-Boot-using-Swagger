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
@Table
public class Employee {

	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;

	private String firstName;

	private String middleName;

	private String lastName;

	private String dateOfBirth;

	private char gender;

	private String email;

	private int mobile;

	private int departmentName;

	private float salary;

	public Employee() {

	}

	public Employee(int employeeId, String firstName, String middleName, String lastName, String dateOfBirth,
			char gender, String email, int mobile, int departmentName, float salary) {

		this.employeeId = employeeId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
		this.mobile = mobile;
		this.departmentName = departmentName;
		this.salary = salary;
	}

}
