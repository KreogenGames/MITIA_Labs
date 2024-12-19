package ru.mirea.mitia.service;

import ru.mirea.mitia.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserDto createUser(UserDto dto);

    UserDto updateUser(UUID id, UserDto dto);

    List<UserDto> getAllUsers();

    UserDto getUser(UUID id);

    void deleteUser(UUID id);
}
