package com.rs.fer.eis.mapper;

import javax.annotation.Generated;

import com.rs.fer.eis.entity.Experience_Details;
import com.rs.fer.eis.request.EditExperienceRequest;
@Generated(value = "org.mapstruct.ap.MappingProcessor", date = "2023-04-19T07:34:40+0530", 
comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)")
public class EditExperienceRequestMapperImpl implements EditExperienceRequestMapper {

	

	

	@Override
	public Experience_Details mapToDetails(EditExperienceRequest request, Experience_Details experienceDetails) {
		if (request == null) {
			return null;
		}
		experienceDetails.setFirm(request.getFirm());
		experienceDetails.setFromDate(request.getFromDate());
		experienceDetails.setToDate(request.getToDate());
		experienceDetails.setId(request.getEmployeeId());
		// TODO Auto-generated method stub
		return experienceDetails;
	}

	

}
