package com.rs.fer.user.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerifyEmailRequest {

	private String id;

	private String verificationCode;
	
}
