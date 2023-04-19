package com.rs.fer.group.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.group.entity.Group;
import com.rs.fer.group.request.SaveGroupRequest;

@Mapper
public interface SaveGroupRequestMapper {

	SaveGroupRequestMapper MAPPER = Mappers.getMapper(SaveGroupRequestMapper.class);

	Group mapToGroup(SaveGroupRequest request);

}
