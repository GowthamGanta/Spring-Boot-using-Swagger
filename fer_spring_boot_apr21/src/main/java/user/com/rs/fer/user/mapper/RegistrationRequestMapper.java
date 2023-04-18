package com.rs.fer.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.user.entity.User;
import com.rs.fer.user.request.RegistrationRequest;

@Mapper(componentModel = "spring")
public interface RegistrationRequestMapper {

	  RegistrationRequestMapper MAPPER = Mappers.getMapper(RegistrationRequestMapper.class);

	  User mapToUser(RegistrationRequest request);
}