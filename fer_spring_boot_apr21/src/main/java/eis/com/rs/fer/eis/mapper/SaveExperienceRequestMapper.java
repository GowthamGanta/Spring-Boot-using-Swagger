package com.rs.fer.eis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.eis.entity.Experience_Details;
import com.rs.fer.eis.request.SaveExperienceRequest;

@Mapper
public interface SaveExperienceRequestMapper {
	SaveExperienceRequestMapper  MAPPER  = Mappers.getMapper(SaveExperienceRequestMapper.class);
	Experience_Details mapToDetails(SaveExperienceRequest request);
	

}
