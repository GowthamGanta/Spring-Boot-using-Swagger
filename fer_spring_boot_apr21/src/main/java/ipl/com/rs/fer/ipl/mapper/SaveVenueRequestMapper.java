package com.rs.fer.ipl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.ipl.entity.Venue;
import com.rs.fer.ipl.request.SaveVenueRequest;

@Mapper(componentModel = "spring")
public interface SaveVenueRequestMapper {

	SaveVenueRequestMapper MAPPER = Mappers.getMapper(SaveVenueRequestMapper.class);

	Venue mapToVenue(SaveVenueRequest request);

}
