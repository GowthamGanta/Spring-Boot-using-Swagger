package com.rs.fer.ipl.mapper;

import com.rs.fer.ipl.entity.Player;
import com.rs.fer.ipl.request.SavePlayerRequest;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T11:06:36+0530",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_331 (Oracle Corporation)"
)
@Component
public class SavePlayerRequestMapperImpl implements SavePlayerRequestMapper {

    @Override
    public Player mapToPlayer(SavePlayerRequest request) {
        if ( request == null ) {
            return null;
        }

        Player player = new Player();

        player.setFirstName( request.getFirstName() );
        player.setMiddleName( request.getMiddleName() );
        player.setLastName( request.getLastName() );
        player.setGender( request.getGender() );
        player.setDob( request.getDob() );
        player.setRole( request.getRole() );
        player.setSpecilization( request.getSpecilization() );
        player.setJerseyNumber( request.getJerseyNumber() );
        player.setTeamId( request.getTeamId() );

        return player;
    }
}
