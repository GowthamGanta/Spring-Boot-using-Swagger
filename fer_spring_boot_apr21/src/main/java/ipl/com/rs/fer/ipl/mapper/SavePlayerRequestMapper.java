package com.rs.fer.ipl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.ipl.entity.Player;
import com.rs.fer.ipl.request.SavePlayerRequest;

@Mapper(componentModel = "spring")
public interface SavePlayerRequestMapper {

	SavePlayerRequestMapper MAPPER = Mappers.getMapper(SavePlayerRequestMapper.class);

	Player mapToPlayer(SavePlayerRequest request);

}
