package com.rs.fer.follow.mapper;

import com.rs.fer.follow.entity.Follow;
import com.rs.fer.follow.request.SaveFollowerRequest;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T09:49:26+0530",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_331 (Oracle Corporation)"
)
public class SaveFollowerRequestMapperImpl implements SaveFollowerRequestMapper {

    @Override
    public Follow mapToFollower(SaveFollowerRequest request) {
        if ( request == null ) {
            return null;
        }

        Follow follow = new Follow();

        follow.setUserId( request.getUserId() );
        follow.setFollowerId( request.getFollowerId() );

        return follow;
    }
}
