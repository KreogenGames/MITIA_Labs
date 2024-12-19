package ru.mirea.mitia.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.mirea.mitia.mapper.UserMapper;
import ru.mirea.mitia.model.UserCreateModel;
import ru.mirea.mitia.model.UserModel;
import ru.mirea.mitia.repository.UserRepository;
import ru.mirea.mitia.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Tag(name = "users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @PostMapping("/users")
    @Operation(summary = "Создание пользователя")
    public ResponseEntity<UserModel> createUser(@RequestBody @Valid UserCreateModel userCreateModel) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userMapper.toModel(userService.createUser(userMapper.toDto(userCreateModel))));
    }
}
