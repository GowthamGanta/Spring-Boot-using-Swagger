package com.rs.fer.ipl.mapper;

import com.rs.fer.ipl.entity.Team;
import com.rs.fer.ipl.request.EditTeamRequest;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T11:06:36+0530",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_331 (Oracle Corporation)"
)
@Component
public class EditTeamRequestMapperImpl implements EditTeamRequestMapper {

    @Override
    public Team mapToTeam(EditTeamRequest request) {
        if ( request == null ) {
            return null;
        }

        Team team = new Team();

        team.setTeamId( request.getTeamId() );
        team.setName( request.getName() );
        team.setTeamCode( request.getTeamCode() );
        team.setCreated( request.getCreated() );
        team.setUpdated( request.getUpdated() );

        return team;
    }
}
