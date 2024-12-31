package org.security.simpleauthenticationspringsecurity.mapper;

import org.mapstruct.Mapper;
import org.security.simpleauthenticationspringsecurity.dto.UserDto;
import org.security.simpleauthenticationspringsecurity.dto.UserRequest;
import org.security.simpleauthenticationspringsecurity.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto userDto);

    UserDto toDto(User user);

    User toEntity(UserRequest request);

    UserRequest toDtoR(User user);
}
