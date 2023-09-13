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
import javax.persistence.OneToOne;
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
	private String gender;
	private String email;

	private String mobile;
	private float salary;
	private String created;
	private String updated;

	// one to many Employee Experience Details
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Experience_Details.class)
	@JoinColumn(name = "eid", referencedColumnName = "employee_id")
	private Set<Experience_Details> experience_Details;

	// One to many Employee Address
	@OneToMany(cascade = CascadeType.ALL, targetEntity = EmployeeAddress.class)
	@JoinColumn(name = "eid", referencedColumnName = "employee_id")
	private Set<EmployeeAddress> employeeAddress;

	// one to many Employee Educational Details
	@OneToMany(cascade = CascadeType.ALL, targetEntity = EducationalDetails.class)
	@JoinColumn(name = "eid", referencedColumnName = "employee_id")
	private Set<EducationalDetails> educationalDetails;

	// one to Many Employee EmployeeRole Details
	@OneToMany(cascade = CascadeType.ALL, targetEntity = EmployeeRole.class)
	@JoinColumn(name = "eid", referencedColumnName = "employee_id")
	private Set<EmployeeRole> employeeRole;

	// one to Many Employee Department
	@OneToOne(cascade = CascadeType.ALL, targetEntity = Department.class)
	@JoinColumn(name = "dept_id", referencedColumnName = "department_id")
	private Department department;

	// one to Many Employee Employee skills
	@OneToMany(cascade = CascadeType.ALL, targetEntity = EmployeeSkills.class)
	@JoinColumn(name = "eid", referencedColumnName = "employee_id")
	private Set<EmployeeSkills> employeeSkills;

	public Employee() {

	}

	public Employee(int employeeId, String firstName, String middleName, String lastName, String dateOfBirth,
			String gender, String email, String mobile, float salary, String created, String updated) {

		this.employeeId = employeeId;
		this.firstName = firstName;
		this.middleName = middleName;

		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;

		this.mobile = mobile;
		this.salary = salary;
		this.created = created;
		this.updated = updated;
	}

}
