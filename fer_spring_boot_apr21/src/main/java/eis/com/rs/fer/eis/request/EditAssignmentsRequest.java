package com.rs.fer.eis.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditAssignmentsRequest {
	
		private String assignmentName;

		private String startDate;

		private String endDate;
		
		private int id;
		
		public int roleId;

		

}
