package com.rs.fer.ipl.request;

public class UpdatePlayerRequest {
	
		private int playerId;
		private String firstName;
		private String middleName;
		private String lastName;
		private char gender;
		private String dob;
		private String role;
		private String specilization;
		private String jerseyNumber;
		

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getMiddleName() {
			return middleName;
		}

		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public char getGender() {
			return gender;
		}

		public void setGender(char gender) {
			this.gender = gender;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getSpecilization() {
			return specilization;
		}

		public void setSpecilization(String specilization) {
			this.specilization = specilization;
		}

		public String getJerseyNumber() {
			return jerseyNumber;
		}

		public void setJerseyNumber(String jerseyNumber) {
			this.jerseyNumber = jerseyNumber;
		}

		public int getPlayerId() {
			return playerId;
		}

		public void setPlayerId(int playerId) {
			this.playerId = playerId;
		}

	}


