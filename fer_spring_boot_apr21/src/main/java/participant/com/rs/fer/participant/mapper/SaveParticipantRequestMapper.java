package com.rs.fer.participant.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.participant.Participant;
import com.rs.fer.participant.request.SaveParticipantRequest;

@Mapper
public interface SaveParticipantRequestMapper {
	
SaveParticipantRequestMapper  MAPPER  = Mappers.getMapper(SaveParticipantRequestMapper.class) ;
	
	Participant mapToParticipant(SaveParticipantRequest request);
}
