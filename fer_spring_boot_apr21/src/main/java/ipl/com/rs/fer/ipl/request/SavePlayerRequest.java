package com.rs.fer.ipl.request;

import lombok.Getter;
import lombok.Setter;
//getters and setter
@Getter
@Setter
public class SavePlayerRequest {

	private String firstName;
	private String middleName;
	private String lastName;
	private char gender;
	private String dob;
	private String role;
	private String specilization;
	private String jerseyNumber;
	private int teamId;
}