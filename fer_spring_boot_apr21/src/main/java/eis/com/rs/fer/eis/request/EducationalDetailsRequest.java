/**
 * 
 */
package com.rs.fer.eis.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EducationalDetailsRequest {

	private String type;

	private String yearOfPassing;

	private String university;

	private int employeeId;
}

