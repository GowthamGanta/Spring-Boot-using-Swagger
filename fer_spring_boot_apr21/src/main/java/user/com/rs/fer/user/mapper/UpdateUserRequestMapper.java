package com.rs.fer.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.user.entity.User;
import com.rs.fer.user.request.UpdateUserRequest;

import com.rs.fer.user.entity.Address;

@Mapper
public interface UpdateUserRequestMapper {

	UpdateUserRequestMapper MAPPER = Mappers.getMapper(UpdateUserRequestMapper.class);

	  User mapToUser(UpdateUserRequest request, User user);
	  
	  Address mapToAddress(UpdateUserRequest request,Address address);
}
