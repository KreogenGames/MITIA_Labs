package ru.mirea.mitia.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.mitia.mapper.UserMapper;
import ru.mirea.mitia.model.UserCreateModel;
import ru.mirea.mitia.model.UserModel;
import ru.mirea.mitia.model.UserUpdateModel;
import ru.mirea.mitia.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Tag(name = "users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/users")
    @Operation(summary = "Создание пользователя")
    public ResponseEntity<UserModel> createUser(@RequestBody @Valid UserCreateModel userCreateModel) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userMapper.toModel(userService.createUser(userMapper.toDto(userCreateModel))));
    }

    @GetMapping("/users")
    @Operation(summary = "Данные пользователей")
    public List<UserModel> getAllUserData() {
        return userMapper.toModels(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    @Operation(summary = "Получение пользователя по id")
    public UserModel getUser(@PathVariable UUID id) {
        return userMapper.toModel(userService.getUser(id));
    }

    @PutMapping("/users/{id}")
    @Operation(summary = "Обновление пользователя")
    public UserModel updateUser(@PathVariable UUID id, @RequestBody @Valid UserUpdateModel userUpdateModel) {
        return userMapper.toModel(userService.updateUser(id, userMapper.toDto(userUpdateModel)));
    }

    @DeleteMapping("/users/{id}")
    @Operation(summary = "Удаление пользователя по id")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
