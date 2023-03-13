package com.rs.fer.user.request;

public class VerifyEmailRequest {

	private String id;

	private String verificationCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	
	
}
