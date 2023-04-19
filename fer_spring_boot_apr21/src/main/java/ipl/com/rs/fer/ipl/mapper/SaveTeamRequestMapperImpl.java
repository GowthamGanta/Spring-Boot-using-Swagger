package com.rs.fer.ipl.mapper;

import com.rs.fer.ipl.entity.Team;
import com.rs.fer.ipl.request.SaveTeamRequest;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T11:06:37+0530",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_331 (Oracle Corporation)"
)
@Component
public class SaveTeamRequestMapperImpl implements SaveTeamRequestMapper {

    @Override
    public Team mapToTeam(SaveTeamRequest request) {
        if ( request == null ) {
            return null;
        }

        Team team = new Team();

        team.setName( request.getName() );
        team.setTeamCode( request.getTeamCode() );

        return team;
    }
}
