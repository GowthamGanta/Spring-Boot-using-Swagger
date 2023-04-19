package com.rs.fer.ipl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.ipl.entity.Team;
import com.rs.fer.ipl.request.SaveTeamRequest;

@Mapper (componentModel = "spring")
public interface SaveTeamRequestMapper {

	SaveTeamRequestMapper MAPPER = Mappers.getMapper(SaveTeamRequestMapper.class);

	Team mapToTeam(SaveTeamRequest request);

}
