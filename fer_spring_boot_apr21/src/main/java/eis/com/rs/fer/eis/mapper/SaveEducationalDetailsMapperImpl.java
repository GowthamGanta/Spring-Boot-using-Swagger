package com.rs.fer.eis.mapper;

import javax.annotation.Generated;

import com.rs.fer.eis.entity.EducationalDetails;
import com.rs.fer.eis.request.EducationalDetailsRequest;

@Generated(value = "org.mapstruct.ap.MappingProcessor", date = "2023-04-19T07:34:40+0530", comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)")
public class SaveEducationalDetailsMapperImpl implements SaveEducationalDetailsRequestMapper {

	

	@Override
	public EducationalDetails mapToEducationalDetails(EducationalDetailsRequest request) {

		if (request == null) {
			return null;
		}
		EducationalDetails educationalDetails = new EducationalDetails();
		
		educationalDetails.setId(request.getEmployeeId());
		educationalDetails.setType(request.getType());
		educationalDetails.setYearOfPassing(request.getYearOfPassing());
		educationalDetails.setUniversity(request.getUniversity());
		
		return educationalDetails;
	}
}
