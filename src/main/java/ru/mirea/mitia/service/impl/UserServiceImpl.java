package ru.mirea.mitia.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mirea.mitia.dto.UserDto;
import ru.mirea.mitia.mapper.UserMapper;
import ru.mirea.mitia.repository.UserRepository;
import ru.mirea.mitia.service.UserService;

import java.util.List;

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
    public UserDto updateUser(UserDto model) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public Boolean deleteUser(Integer id) {
        return null;
    }
}
