package com.rs.fer.eis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.eis.entity.EducationalDetails;
import com.rs.fer.eis.request.EducationalDetailsRequest;

@Mapper
public interface SaveEducationalDetailsRequestMapper {

	SaveEducationalDetailsRequestMapper MAPPER = Mappers.getMapper(SaveEducationalDetailsRequestMapper.class);

	EducationalDetails mapToEducationalDetails(EducationalDetailsRequest request);
}
