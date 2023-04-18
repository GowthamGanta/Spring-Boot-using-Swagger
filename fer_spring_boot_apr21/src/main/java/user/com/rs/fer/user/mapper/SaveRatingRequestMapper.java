package com.rs.fer.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.rs.fer.user.entity.Rating;
import com.rs.fer.user.request.SaveRatingRequest;

@Mapper
public interface SaveRatingRequestMapper {

	SaveRatingRequestMapper MAPPER = Mappers.getMapper(SaveRatingRequestMapper.class);

	@Mapping(source = "reviewerId", target = "reviewedBy")
	Rating mapToRating(SaveRatingRequest request);

}
