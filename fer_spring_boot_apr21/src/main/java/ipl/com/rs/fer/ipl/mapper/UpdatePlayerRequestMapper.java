package com.rs.fer.ipl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.ipl.entity.Player;
import com.rs.fer.ipl.request.UpdatePlayerRequest;

@Mapper(componentModel = "spring")
public interface UpdatePlayerRequestMapper {
	
	UpdatePlayerRequestMapper MAPPER = Mappers.getMapper(UpdatePlayerRequestMapper.class);
	Player mapToPlayer (UpdatePlayerRequest request);

}
