package com.rs.fer.user.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.rs.fer.eis.entity.Employee;
import com.rs.fer.follow.entity.Follow;
import com.rs.fer.group.entity.Group;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
@Entity
@Table
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column
	private String firstname;

	@Column
	private String middlename;

	@Column
	private String lastname;
	
	@Column
	private String email;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String mobile;
	
	@Column
	private String created;
	
	@Column
	private String updated;
	
	@Column
	private String otp;
	
	@Column
	private String verificationCode;
	
	@Column
	private String mobileVerify;
	
	@Column
	private String emailVerify;
	
	@Column
	private String blockStatus;

	public User() {

	}

	public User(String firstname, String middlename, String lastname, String email, String username, String password,
			String mobile) {

		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.mobile = mobile;
	}
	
    @OneToMany(targetEntity = Follow.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private Set<Follow> followers;
	
	@OneToMany(targetEntity = Rating.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Rating> ratings;
	
	@OneToMany(targetEntity = Employee.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private Set<Employee> expenses;
	
	@OneToOne(targetEntity = Address.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "addr_id", referencedColumnName = "address_id")
	private Address address;

	@OneToMany(targetEntity = Group.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private Set<Group> groups;
}
