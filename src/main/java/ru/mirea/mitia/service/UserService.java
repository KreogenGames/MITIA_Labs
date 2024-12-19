package ru.mirea.mitia.service;

import ru.mirea.mitia.model.UserModel;

import java.util.List;

public interface UserService {

    UserModel createUser(UserModel model);

    UserModel updateUser(UserModel model);

    List<UserModel> getAllUsers();

    Boolean deleteUser(Integer id);
}
