package com.rs.fer.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.rs.fer.user.entity.Rating;
import com.rs.fer.user.request.EditRatingRequest;

@Mapper
public interface EditRatingRequestMapper {

	EditRatingRequestMapper MAPPER = Mappers.getMapper(EditRatingRequestMapper.class);

	@Mapping(source = "ratingId", target = "id")
	@Mapping(source = "reviewerId", target = "reviewedBy")
	Rating mapToRating(EditRatingRequest request);
}
