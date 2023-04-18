package com.rs.fer.user.mapper;

import com.rs.fer.user.entity.User;
import com.rs.fer.user.request.RegistrationRequest;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-18T12:16:17+0530",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)"
)
@Component
public class RegistrationRequestMapperImpl implements RegistrationRequestMapper {

    @Override
    public User mapToUser(RegistrationRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setFirstname( request.getFirstname() );
        user.setMiddlename( request.getMiddlename() );
        user.setLastname( request.getLastname() );
        user.setEmail( request.getEmail() );
        user.setUsername( request.getUsername() );
        user.setPassword( request.getPassword() );
        user.setMobile( request.getMobile() );

        return user;
    }
}
