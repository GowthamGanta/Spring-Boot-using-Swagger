package com.rs.fer.eis.mapper;

import javax.annotation.Generated;

import com.rs.fer.eis.entity.Experience_Details;
import com.rs.fer.eis.request.SaveExperienceRequest;

@Generated(value = "org.mapstruct.ap.MappingProcessor", date = "2023-04-19T07:34:40+0530", comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)")
public class SaveExperienceRequestMapperImpl implements SaveExperienceRequestMapper {

	public Experience_Details mapToDetails(SaveExperienceRequest request) {
		if (request == null) {
			return null;
		}
		Experience_Details details = new Experience_Details();
		details.setFirm(request.getFirm());
		details.setFromDate(request.getFromDate());
		details.setToDate(request.getToDate());
		details.setId(request.getEid());

		return details;
	}

}
