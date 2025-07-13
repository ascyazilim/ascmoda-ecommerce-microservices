package com.ascmoda.userservice.mapper;

import com.ascmoda.userservice.dto.UserRequestDTO;
import com.ascmoda.userservice.dto.UserResponseDTO;
import com.ascmoda.userservice.dto.UserUpdateDTO;
import com.ascmoda.userservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseDTO toResponseDTO(User user);

    User toEntity(UserRequestDTO dto);

    void updateUserFromDto(UserUpdateDTO dto, User user);
}
