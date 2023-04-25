package com.rs.fer.user.mapper;

import com.rs.fer.user.entity.Address;
import com.rs.fer.user.entity.User;
import com.rs.fer.user.request.UpdateUserRequest;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T14:50:42+0530",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)"
)
public class UpdateUserRequestMapperImpl implements UpdateUserRequestMapper {

    @Override
    public User mapToUser(UpdateUserRequest request, User user) {
        if ( request == null ) {
            return null;
        }

        user.setUserId( request.getUserId() );
        user.setFirstname( request.getFirstname() );
        user.setMiddlename( request.getMiddlename() );
        user.setLastname( request.getLastname() );
        user.setEmail( request.getEmail() );
        user.setMobile( request.getMobile() );

        return user;
    }

    @Override
    public Address mapToAddress(UpdateUserRequest request, Address address) {
        if ( request == null ) {
            return null;
        }

       // address.setAddressId( request.getAddressId() );
        address.setLineone( request.getLineone() );
        address.setLinetwo( request.getLinetwo() );
        address.setCity( request.getCity() );
        address.setState( request.getState() );
        address.setPincode( request.getPincode() );
        address.setCountry( request.getCountry() );

        return address;
    }
}
