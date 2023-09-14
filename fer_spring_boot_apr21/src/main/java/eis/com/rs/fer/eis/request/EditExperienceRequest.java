package com.rs.fer.eis.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditExperienceRequest {
	private String firm;
	private String fromDate;

	private String toDate;
	private int employeeId;
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
