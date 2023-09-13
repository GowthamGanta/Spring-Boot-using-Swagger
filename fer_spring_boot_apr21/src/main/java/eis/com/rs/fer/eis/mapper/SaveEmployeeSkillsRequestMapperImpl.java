package com.rs.fer.eis.mapper;

import javax.annotation.Generated;


import com.rs.fer.eis.entity.EmployeeSkills;
import com.rs.fer.eis.request.SaveEmployeeSkillsRequest;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T07:34:40+0530",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)"
)
public class SaveEmployeeSkillsRequestMapperImpl implements SaveEmployeeSkillsRequestMapper {

   

	@Override
	public EmployeeSkills mapToEmployeeSkills(SaveEmployeeSkillsRequest request) {
		
		if(request == null) {
			return null;
		}
		EmployeeSkills employeeSkills = new EmployeeSkills();

		employeeSkills.setEmployeeId(request.getEmployeeId());
        
		return employeeSkills;
	}
}
