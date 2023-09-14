package com.rs.fer.eis.mapper;

import org.mapstruct.factory.Mappers;

import com.rs.fer.eis.entity.Experience_Details;
import com.rs.fer.eis.request.EditExperienceRequest;

public interface EditExperienceRequestMapper {
	EditExperienceRequestMapper MAPPER = Mappers.getMapper(EditExperienceRequestMapper.class);

	Experience_Details mapToDetails(EditExperienceRequest request, Experience_Details experienceDetails);

}
