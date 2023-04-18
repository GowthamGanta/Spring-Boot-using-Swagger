package com.rs.fer.user.mapper;

import com.rs.fer.user.entity.Address;
import com.rs.fer.user.entity.User;
import com.rs.fer.user.request.UpdateUserRequest;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-18T16:02:37+0530",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)"
)
public class UpdateUserRequestMapperImpl implements UpdateUserRequestMapper {

    @Override
    public User mapToUser(UpdateUserRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( request.getUserId() );
        user.setFirstname( request.getFirstname() );
        user.setMiddlename( request.getMiddlename() );
        user.setLastname( request.getLastname() );
        user.setEmail( request.getEmail() );
        user.setUsername( request.getUsername() );
        user.setPassword( request.getPassword() );
        user.setMobile( request.getMobile() );
        user.setCreated( request.getCreated() );

        return user;
    }

    @Override
    public Address mapToAddress(UpdateUserRequest request) {
        if ( request == null ) {
            return null;
        }

        Address address = new Address();

        address.setAddressId( request.getAddressId() );
        address.setLineone( request.getLineone() );
        address.setLinetwo( request.getLinetwo() );
        address.setCity( request.getCity() );
        address.setState( request.getState() );
        address.setPincode( request.getPincode() );
        address.setCountry( request.getCountry() );
        address.setCreated( request.getCreated() );

        return address;
    }
}
