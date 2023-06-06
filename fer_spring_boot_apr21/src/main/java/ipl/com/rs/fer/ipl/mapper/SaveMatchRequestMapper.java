package com.rs.fer.ipl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.ipl.entity.IPLMatch;
import com.rs.fer.ipl.entity.Player;
import com.rs.fer.ipl.request.SaveMatchRequest;
import com.rs.fer.ipl.request.SavePlayerRequest;

@Mapper(componentModel = "spring")
public interface SaveMatchRequestMapper {

	SaveMatchRequestMapper MAPPER = Mappers.getMapper(SaveMatchRequestMapper.class);

	IPLMatch mapToMatch(SaveMatchRequest request);

}
