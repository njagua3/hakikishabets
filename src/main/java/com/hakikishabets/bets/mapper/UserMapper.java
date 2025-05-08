package com.hakikishabets.bets.mapper;

import com.hakikishabets.bets.dto.UserRequestDTO;
import com.hakikishabets.bets.dto.UserResponseDTO;
import com.hakikishabets.bets.model.User;

public class UserMapper {

    // Convert UserRequestDTO to User entity
    public static User toEntity(UserRequestDTO dto) {
        return new User(dto.getUsername(), dto.getEmail(), dto.getBalance());
    }

    // Convert User entity to UserResponseDTO
    public static UserResponseDTO toDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setBalance(user.getBalance());
        return dto;
    }
}
