package ru.mirea.mitia.service;

import ru.mirea.mitia.dto.UserDto;
import ru.mirea.mitia.model.UserModel;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto dto);

    UserDto updateUser(UserDto model);

    List<UserDto> getAllUsers();

    Boolean deleteUser(Integer id);
}
