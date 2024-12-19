package ru.mirea.mitia.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.mitia.dto.UserDto;
import ru.mirea.mitia.mapper.UserMapper;
import ru.mirea.mitia.repository.UserRepository;
import ru.mirea.mitia.service.UserService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto dto) {
        var entity = userMapper.toEntity(dto);
        var save = userRepository.save(entity);

        return userMapper.toDto(save);
    }

    @Override
    @Transactional
    public UserDto updateUser(UUID id, UserDto dto) {
        var user = userRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Пользователя с таким " + id + " id не существует"));

        userMapper.updateFromDto(dto, user);
        var savedUser = userRepository.save(user);

        return userMapper.toDto(savedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        var users = userRepository.findAll();

        return userMapper.toDtos(users.stream().toList());
    }

    @Override
    public UserDto getUser(UUID id) {
        var user = userRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Пользователя с таким " + id + " id не существует"));

        return userMapper.toDto(user);
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
