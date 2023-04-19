package com.rs.fer.ipl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.ipl.entity.Team;
import com.rs.fer.ipl.request.EditTeamRequest;

@Mapper(componentModel="spring")
public interface EditTeamRequestMapper {
	EditTeamRequestMapper MAPPER = Mappers.getMapper(EditTeamRequestMapper.class);
	Team mapToTeam (EditTeamRequest request);

}
