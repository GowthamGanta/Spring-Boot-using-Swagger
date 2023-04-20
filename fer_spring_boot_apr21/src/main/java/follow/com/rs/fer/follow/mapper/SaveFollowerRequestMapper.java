package com.rs.fer.follow.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.follow.entity.Follow;
import com.rs.fer.follow.request.SaveFollowerRequest;

@Mapper
public interface SaveFollowerRequestMapper {

	SaveFollowerRequestMapper MAPPER = Mappers.getMapper(SaveFollowerRequestMapper.class);

	//@Mapping(source = "userId", target = "usedBy")
	Follow mapToFollower(SaveFollowerRequest request);

}
