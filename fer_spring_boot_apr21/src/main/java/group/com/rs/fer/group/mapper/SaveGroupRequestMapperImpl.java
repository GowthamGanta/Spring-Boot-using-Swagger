package com.rs.fer.group.mapper;

import com.rs.fer.group.entity.Group;
import com.rs.fer.group.request.SaveGroupRequest;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T09:40:16+0530",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)"
)
public class SaveGroupRequestMapperImpl implements SaveGroupRequestMapper {

    @Override
    public Group mapToGroup(SaveGroupRequest request) {
        if ( request == null ) {
            return null;
        }

        Group group = new Group();

        group.setUserId( request.getUserId() );
        group.setGroupName( request.getGroupName() );

        return group;
    }
}
