package com.security.demo.mapper;

import com.security.demo.model.dto.UserDto;
import com.security.demo.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserMapper {
    User toEntity(UserDto dto);
    UserDto toDto(User entity);
}
