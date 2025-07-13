package com.ascmoda.userservice.service.impl;

import com.ascmoda.userservice.dto.UserRequestDTO;
import com.ascmoda.userservice.dto.UserResponseDTO;
import com.ascmoda.userservice.dto.UserUpdateDTO;
import com.ascmoda.userservice.exception.UserNotFoundException;
import com.ascmoda.userservice.mapper.UserMapper;
import com.ascmoda.userservice.model.User;
import com.ascmoda.userservice.repository.UserRepository;
import com.ascmoda.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = userMapper.toEntity(dto);
        User savedUser = userRepository.save(user);
        return userMapper.toResponseDTO(savedUser);
    }

    @Override
    public UserResponseDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));
        return userMapper.toResponseDTO(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void deleteUser(UUID id) {
        if (!userRepository.existsById(id)){
            throw new UserNotFoundException("User not found with id: " +id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserResponseDTO updateUser(UUID id, UserUpdateDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " +id));
        userMapper.updateUserFromDto(dto, user);
        User updated = userRepository.save(user);
        return
                userMapper.toResponseDTO(updated);
    }
}
