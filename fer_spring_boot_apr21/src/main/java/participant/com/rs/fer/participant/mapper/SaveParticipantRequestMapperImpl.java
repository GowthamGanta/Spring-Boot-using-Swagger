package com.rs.fer.participant.mapper;

import com.rs.fer.participant.Participant;
import com.rs.fer.participant.request.SaveParticipantRequest;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T09:48:32+0530",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)"
)
public class SaveParticipantRequestMapperImpl implements SaveParticipantRequestMapper {

    @Override
    public Participant mapToParticipant(SaveParticipantRequest request) {
        if ( request == null ) {
            return null;
        }

        Participant participant = new Participant();

        participant.setGroupId( request.getGroupId() );
        participant.setParticipantId( request.getParticipantId() );

        return participant;
    }
}
