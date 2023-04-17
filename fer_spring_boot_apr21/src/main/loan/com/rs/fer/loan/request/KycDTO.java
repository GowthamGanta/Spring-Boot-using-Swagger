package com.rs.fer.loan.request;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class KycDTO {

	private String docType;
	private String docCode;
	private String dateOfIssue;
	private String dateOfExpiry;
	private String placeOfIssue;
}
