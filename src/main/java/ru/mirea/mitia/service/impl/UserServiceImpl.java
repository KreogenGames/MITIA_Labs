package ru.mirea.mitia.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mirea.mitia.model.UserModel;
import ru.mirea.mitia.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public UserModel createUser(UserModel model) {
        return null;
    }

    @Override
    public UserModel updateUser(UserModel model) {
        return null;
    }

    @Override
    public List<UserModel> getAllUsers() {
        return List.of();
    }

    @Override
    public Boolean deleteUser(Integer id) {
        return null;
    }
}
