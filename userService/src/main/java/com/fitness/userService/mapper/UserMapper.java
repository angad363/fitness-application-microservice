package com.fitness.userService.mapper;

import com.fitness.userService.dto.UserResponse;
import com.fitness.userService.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponse userToUserResponse(User user);
}
