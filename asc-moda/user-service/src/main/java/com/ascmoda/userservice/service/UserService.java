package com.ascmoda.userservice.service;

import com.ascmoda.userservice.dto.UserRequestDTO;
import com.ascmoda.userservice.dto.UserResponseDTO;
import com.ascmoda.userservice.dto.UserUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO dto);

    UserResponseDTO getUserByEmail(String email);

    List<UserResponseDTO> getAllUsers();

    void deleteUser(UUID id);

    UserResponseDTO updateUser(UUID id, UserUpdateDTO dto);
}
